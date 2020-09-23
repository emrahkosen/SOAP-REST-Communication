package io.order.order;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<Order, String> 
{
	Order findByCustomerAndProduct(int customer, int product);
	List<Order> findAllByCustomer(int customer);
	List<Order> findAllByProduct(int product);
	
	boolean existsByCustomer(int customer);
	boolean existsByProduct(int product);
	boolean existsByCustomerAndProduct(int customer, int product);
	
	Long deleteByProduct(int product);
	Long deleteByCustomer(int customer);
	Long deleteOneByProductAndCustomer(int product, int customer);
	
}
