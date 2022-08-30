package com.carwash.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.order.models.Order;
import com.carwash.order.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	public Order addOrder(Order order) {
		return repository.save(order);
	}
	
	public List<Order> getOrder() {
		List<Order> order = repository.findAll();
		System.out.println("Getting data from DB : " + order);
		return order;
	}
	
	public void deleteOrder(String orderId) {
		repository.deleteById(orderId);
	}

	public Optional<Order> getByOrderId(String orderId) {
		return repository.findByOrderId(orderId);
	}
	public Order getByOrderEmail(String emailId) {
		return repository.findByEmail(emailId);
	}

	
}
