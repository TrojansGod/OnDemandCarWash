package com.carwash.order.controllers;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carwash.order.models.Order;
import com.carwash.order.models.Pay;
import com.carwash.order.repositories.OrderRepository;
import com.carwash.order.services.OrderService;
@RestController
@RequestMapping("/order")
@CrossOrigin()
public class OrderController {
	
	
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private OrderRepository repo;
	
	
	@GetMapping("/getall")
	public List<Order> getOrder(){
		return service.getOrder();
	}
	@GetMapping("/washer/order/{emailId}")
	public List<Order> washerOrder(@PathVariable("emailId") String emailId)
	{
		//RestTemplate r= new RestTemplate();	
		//Boolean b= r.getForObject("http://localhost:8082/washer/getpass/"+emailId,Boolean.class);
		List<Order> p=null;
		//if(Boolean.TRUE.equals(b))
		//{
			p=getByWasherId(emailId);
		//}
		return p;
	}
	@PutMapping("/updatePaymentStatus")
	public Order updatePaymentStatus(@RequestBody Pay o) {
		
		Optional<Order> d= repo.findById(o.getOrderId());
		Order c=d.get();
		c.setSuccess(o.getSuccess());
		return repo.save(c);
	}
	
		
	@PostMapping("/register")
	public ResponseEntity<String> insertOrder(@RequestBody Order order) {
		System.out.println("Order generated");
		service.addOrder(order);
		RestTemplate r= new RestTemplate();
		String j=r.getForObject("http://localhost:8080/val/"+order.getOrderId()+"/"+order.getWasherId()+"/"+order.getEmailId()+"/"+order.getCost(),String.class);
		System.out.println("HI");
		return new ResponseEntity<String>("Success"+j, HttpStatus.OK);
	}
	
	
	public List<Order> getByWasherId(@PathVariable("orderId") String washerId) {
		return repo.getBywasherId(washerId);
	}
	@GetMapping("/getemail/{emailId}")
	public List<Order> getByEmailOrder(@PathVariable("emailId") String emailId) {
		return repo.getByemailId(emailId);
	}
}
