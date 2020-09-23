package io.order.product;

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



@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getAllProduct()
	{
		return productService.getAll();
	}
	
	
	@GetMapping("/{id}") 
	public Product getProduct(@PathVariable int id)
	{
		return productService.getWithId(id);
	}
	
	@PostMapping
	public String addPerson(@RequestBody Product product)
	{
		return productService.save(product);
	}
	
	@PutMapping("/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody Product product)
	{
		return productService.update(id, product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return productService.delete(id);
	}
	
}
