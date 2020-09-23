package io.order.request;

import java.net.URI;
import java.util.List;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.details.product.ProductDetails;

import io.order.product.Product;



@Service
public class Requests 
{

	private final RestTemplate restTemplate;
	String url = "http://localhost:5544/product";
	
	
	public Requests(RestTemplateBuilder restTemplateBuilder) 
	{
        this.restTemplate = restTemplateBuilder.build();
    }



	public List<ProductDetails> getAllProducts()
	{
		
		//return restTemplate.getForObject(url, ProductDetails.class);
		
		
		ResponseEntity<List<ProductDetails>> responseEntity =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductDetails>>() {
                        });
		List<ProductDetails> products = responseEntity.getBody();
		return products;
		

	}
	
	public ProductDetails getProduct(int id)
	{
		String url_id = url + "/" +id;
		
		return restTemplate.getForObject(url_id, ProductDetails.class);
		
	}
	
	
	public String postProduct(ProductDetails product)
	{
		String ret = restTemplate.postForEntity(url, product, String.class).toString();
		return ret;
	}
	
}
