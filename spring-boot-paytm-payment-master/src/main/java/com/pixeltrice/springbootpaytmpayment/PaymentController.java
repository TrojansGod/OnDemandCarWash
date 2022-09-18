package com.pixeltrice.springbootpaytmpayment;

import java.util.Map;

import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


import com.paytm.pg.merchant.PaytmChecksum;

@RestController
@CrossOrigin()
public class PaymentController {
	public String a,b;
	public String orderId,washerId,emailId,cost;
	//private Repository repo;
	@Autowired
	private PaytmDetailPojo paytmDetailPojo;
	@Autowired
	private Environment env;
	
	@GetMapping("/val/{OrderId}/{washerId}/{emailId}/{cost}")
	public String s(@PathVariable("OrderId") String OrderId,@PathVariable("washerId") String washerId,@PathVariable("emailId") String emailId,@PathVariable("cost") String cost)
	{
		this.orderId=OrderId;
		this.washerId=washerId;
		this.emailId=emailId;
		this.cost=cost;
		return "success";
	}
	
	@GetMapping("/homepage")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("home");
		return modelAndView ;
	}

	 @PostMapping(value = "/submitPaymentDetail")
	    public ModelAndView getRedirect(@RequestParam(name = "CUST_ID") String customerId,
	                                    @RequestParam(name = "TXN_AMOUNT") String transactionAmount,
	                                    @RequestParam(name = "ORDER_ID") String orderId) throws Exception {
		 	customerId=this.emailId;
		 	transactionAmount=this.cost;
		 	orderId=this.orderId;
		 	
		 	a=customerId;
		 	b=orderId;
		 	
	        ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetailPojo.getPaytmUrl());
	        TreeMap<String, String> parameters = new TreeMap<>();
	        paytmDetailPojo.getDetails().forEach((k, v) -> parameters.put(k, v));
	        parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
	        parameters.put("EMAIL", env.getProperty("paytm.email"));
	        parameters.put("ORDER_ID", orderId);
	        parameters.put("TXN_AMOUNT", transactionAmount);
	        parameters.put("CUST_ID", customerId);
	        String checkSum = getCheckSum(parameters);
	        parameters.put("CHECKSUMHASH", checkSum);
	        modelAndView.addAllObjects(parameters);
	        return modelAndView;
	    }
	 
	 
	 @PostMapping(value = "/pgresponse")
	    public ModelAndView getResponseRedirect(HttpServletRequest request, Model model) {

	        Map<String, String[]> mapData = request.getParameterMap();
	        TreeMap<String, String> parameters = new TreeMap<String, String>();
	        String paytmChecksum = "";
	        for (Entry<String, String[]> requestParamsEntry : mapData.entrySet()) {
	            if ("CHECKSUMHASH".equalsIgnoreCase(requestParamsEntry.getKey())){
	                paytmChecksum = requestParamsEntry.getValue()[0];
	            } else {
	            	parameters.put(requestParamsEntry.getKey(), requestParamsEntry.getValue()[0]);
	            }
	        }
	        String result;

	        boolean isValideChecksum = false;
	        System.out.println("RESULT : "+parameters.toString());
	        try {
	            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
	            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
	                if (parameters.get("RESPCODE").equals("01")) {
	                    result = "Payment Successful";
	                } else {
	                    result = "Payment Failed";
	                }
	            } else {
	                result = "Checksum mismatched";
	            }
	        } catch (Exception e) {
	            result = e.toString();
	        }
	        model.addAttribute("result",result);
	        parameters.remove("CHECKSUMHASH");
	        model.addAttribute("parameters",parameters);
	        
	        
	        	Pay o =new Pay(this.orderId,parameters.get("STATUS"));
	    		RestTemplate restTemplate = new RestTemplate();
	    		restTemplate.put("http://localhost:8083/order/updatePaymentStatus",o,String.class);
	    		ModelAndView modelAndView = new ModelAndView();
	    	    modelAndView.setViewName("report");
	    	    parameters=null;
	        return modelAndView;
	    }

	    private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
	        return PaytmChecksum.verifySignature(parameters,
	                paytmDetailPojo.getMerchantKey(), paytmChecksum);
	    }


	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return PaytmChecksum.generateSignature(parameters, paytmDetailPojo.getMerchantKey());
	}
	
	
	
}

