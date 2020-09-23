package io.order.product;

public class Product 
{
	private Long id;
	private String name;
	public Product() {
		super();
	}
	public Product(Long id) {
		super();
		this.id = id;
	}
	public Product(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
	
	
}
