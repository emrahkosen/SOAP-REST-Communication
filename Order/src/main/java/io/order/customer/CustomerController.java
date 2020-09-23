package io.order.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.order.product.Product;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping
	public List<Customer> getCustomers()
	{
		return customerService.getAll();
	}
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable int id)
	{
		return customerService.getById(id);
	}
	
	@PostMapping
	public String savePerson(@RequestBody Customer customer)
	{
		return customerService.save(customer);
	}
	
	@PutMapping("/{id}")
	public String updateCustomer(@PathVariable int id, @RequestBody Customer customer)
	{
		return customerService.update(id, customer);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		return customerService.delete(id);
	}
	
	@GetMapping("/{id}/product")
	public String findProductsByOwner(@PathVariable int id)
	{
		return customerService.getProductsByCutomerId(id);
	}


}
