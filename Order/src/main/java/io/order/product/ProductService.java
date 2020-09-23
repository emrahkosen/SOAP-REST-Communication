package io.order.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.order.customer.CustomerRepo;
import io.order.order.OrderRepo;

@Service
public class ProductService 
{
	@Autowired
	ProductRepo productRepo;
	@Autowired
	CustomerRepo customRepo;
	
	@Autowired
	OrderRepo orderRepo;
	
	public List<Product> getAll()
	{
		return productRepo.findAll();
	}
	public Product getWithId(int id)
	{
		if(productRepo.existsById(id))
			return productRepo.findById(id).get();
		else 
			return null;
	}
	
	public String save(Product product )
	{

		if(productRepo.existsById(product.getId()) )
			return "Not Saved. There is a product with same id!!";
		
		productRepo.save(product);
		return "saved";
	}

	public String update(int id, Product product)
	{
		if(productRepo.existsById(id))
		{

			productRepo.save(product);
			return "updated";
			
		}
		else
			return "not Updated, no product with given id!!";
	}
	
	public String delete(int id)
	{
		if(productRepo.existsById(id))
		{
			productRepo.deleteById(id);
			orderRepo.deleteByProduct(id);//if product is deleted, all order related to this product is also deleted.
			return "deleted";
		}
		return "No User To delete";
	}
}
