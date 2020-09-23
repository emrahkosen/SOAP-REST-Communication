package io.order.order;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "order")
public class Order 
{
	@Id
	private String id;
	private int customer;
	private int product;
	private int count;
	public Order(int customer, int product) 
	{
		this.customer = customer;
		this.product = product;
		this.count = 1;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCustomer() {
		return customer;
	}
	public void setCustomer(int customer) {
		this.customer = customer;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int order) {
		this.product = order;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customer_id=" + customer + ", product_id=" + product + "]";
	}
	
	
	
	
}
