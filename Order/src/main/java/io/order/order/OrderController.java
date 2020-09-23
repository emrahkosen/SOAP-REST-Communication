package io.order.order;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	OrderRepo orderRepo;
	@Autowired
	OrderService orderService;

	
	
	@GetMapping
	public List<Order> getOrders()
	{
		return orderRepo.findAll(); 
		
	}
	@GetMapping("/{customer}/{product}")
	public boolean findexists(@PathVariable int customer, @PathVariable int product)
	{
		return orderRepo.existsByCustomerAndProduct(customer, product);
	}
	
	@GetMapping("/customer/{customer}")
	public boolean findexistsBycustomer(@PathVariable int customer)
	{
		return orderRepo.existsByCustomer(customer);
	}
	
	
	
	
	@PostMapping
	public String addOrder(@RequestBody Order order)
	{
		System.out.println(order.toString());
		return orderService.save(order);

	}
	
	
	
	@DeleteMapping("/{id}")
	public String deleteOrder(@PathVariable String id)
	{
		Order ord = orderRepo.findById(id).get();
		orderRepo.deleteById(id);
		return ord.toString();
	}
	
	
	@DeleteMapping("/drop/{customer}/{product}")
	public String dropOrder(@PathVariable int customer, @PathVariable int product)
	{
		return orderService.dropOrder(customer, product);
	}
	
	@DeleteMapping("/customer/{customer}")
	public Long deleteCustomProd(@PathVariable int customer)
	{
		return orderRepo.deleteByCustomer( customer);
	}
}
