package io.order.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.order.order.Order;
import io.order.order.OrderRepo;
import io.order.order.OrderService;
import io.order.product.Product;
import io.order.product.ProductRepo;

@Service
public class CustomerService 
{
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	OrderRepo orderRepo;
	
	
	
	public List<Customer> getAll()
	{
		return customerRepo.findAll();
	}
	
	public Customer getById(int id)
	{
		if(!customerRepo.existsById(id))
			return null;
		
		return customerRepo.findById(id).get();
	}
	
	public String save(Customer customer)
	{
		if(customerRepo.existsById(customer.getId()))
			return "not saved, exist another user given id";
		customerRepo.save(customer);
		return "saved";
	}
	
	public String update(int id, Customer customer)
	{
		if(customerRepo.existsById(id) == false)
		{
			return "there is no user to update!!";
		}
		else if(id != customer.getId())
		{
			return "ids are not match!!";
		}
		else
		{
			customerRepo.save(customer);
			return "updated";
		}
	}
	
	public String delete(int id)
	{
		if(customerRepo.existsById(id) == false)
			return "there is no user to delete!!";
		else
		{
			orderRepo.deleteByCustomer(id);
			customerRepo.deleteById(id);
			return "deleted!!";
		}
	}
	
	public String getProductsByCutomerId(int id)
	{
		List<Order> orders = orderRepo.findAllByCustomer(id);
		String ret = "";
		for(Order order : orders)
		{
			Product product = productRepo.findById(order.getProduct()).get();
			ret += product.toString() + ", count of order: " + order.getCount() + "\n";
		}
		return ret;

	}
	
} 
















