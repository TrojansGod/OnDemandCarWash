package com.carwash.order.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.order.models.Order;
import com.carwash.order.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	UUID uuid=UUID.randomUUID(); 
	
	public Order addOrder(Order order) {
		order.setOrderId(uuid.toString());
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

	public Optional<Order> getByOrderId(String washerId) {
		return repository.findById(washerId);
	}
	
}
