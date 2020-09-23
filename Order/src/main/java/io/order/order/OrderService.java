package io.order.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.order.customer.CustomerRepo;
import io.order.product.ProductRepo;


@Service
public class OrderService 
{
	
	@Autowired
	OrderRepo orderRepo;
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	ProductRepo productRepo;
	
	public String save(Order order)
	{
		if(customerRepo.existsById(order.getCustomer()) == false)
		{
			return "there is no customer given id!!";
		}
		else if(productRepo.existsById(order.getProduct()) == false)
		{
			return "there is no order given id!!";
		}
			
		else if(orderRepo.existsByCustomerAndProduct(order.getCustomer(), order.getProduct()))
		{
			Order order_update = orderRepo.findByCustomerAndProduct(order.getCustomer(), order.getProduct());
			order_update.setCount( order_update.getCount() + 1);
			orderRepo.save(order_update);
			return "order is updated!!";
		}
		else
		{
			orderRepo.save(order);
			return "order is saved!!";
		}
		
	}
	
	public List<Order> findByCustomerId(int customer)
	{
		return orderRepo.findAllByCustomer(customer);
	}
	
	public List<Order> findByProductId(int product)
	{
		return orderRepo.findAllByProduct(product);
	}
	
	
	
	
	public String dropOrder(int customer, int product)
	{
		if(orderRepo.existsByCustomerAndProduct(customer, product) == false)
		{
			return "there is no order to drop!!";
		}
		else if(orderRepo.findByCustomerAndProduct(customer, product).getCount() > 1)
		{
			Order order_update = orderRepo.findByCustomerAndProduct(customer, product);
			order_update.setCount( order_update.getCount() - 1);
			orderRepo.save(order_update);
			return "order is decreased!! current count: " + order_update.getCount();
		}
		else
		{
			orderRepo.deleteOneByProductAndCustomer(product, customer);
			return "order is deleted!!";
		}
	}
	
	public String deleteByProductId(int productId)
	{
		if(orderRepo.existsByProduct(productId) == false)
		{
			return "no order with given product";
		}
		
		else
		{
			return orderRepo.deleteByProduct(productId) + " order(s) is deleted!!";
		}
	}
	
	public String deleteByCustomerId(int customerId)
	{
		if(orderRepo.existsByCustomer(customerId) == false)
		{
			return "no order to delete with given customer";
		}
		else
		{
			return orderRepo.deleteByCustomer(customerId) + "order(s) is deleted!!";
		}
	}
}
