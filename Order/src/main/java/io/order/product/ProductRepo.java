package io.order.product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepo extends MongoRepository<Product, Integer> 
{	
	//public void deleteAllByOwnerid(int ownerid);
	//public List<Product> findAllByOwnerid(int ownerid);
	
}
