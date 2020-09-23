package io.order.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.details.product.GetAllProductDetailsRequest;
import com.details.product.GetAllProductDetailsResponse;
import com.details.product.GetProductDetailsRequest;
import com.details.product.GetProductDetailsResponse;
import com.details.product.PostProductDetailsRequest;
import com.details.product.PostProductDetailsResponse;
import com.details.product.ProductDetails;

import io.order.request.Requests;

@Endpoint
public class ProductDetailsEndpoint 
{
	@Autowired
	Requests requests;
	
	
	@PayloadRoot(namespace = "http://details.com/product", localPart = "GetAllProductDetailsRequest")
	@ResponsePayload
	public GetAllProductDetailsResponse processAllProductDetailRequest(@RequestPayload GetAllProductDetailsRequest request)
	{
		GetAllProductDetailsResponse response = new GetAllProductDetailsResponse();
		
		response.setAllProductDetails(requests.getAllProducts());
		return response;
	}
	
	
	
	
	
	@PayloadRoot(namespace = "http://details.com/product", localPart = "GetProductDetailsRequest")
	@ResponsePayload
	public GetProductDetailsResponse processProductDetailRequest(@RequestPayload GetProductDetailsRequest request)
	{
		GetProductDetailsResponse response = new GetProductDetailsResponse();
		
		response.setProductDetails(requests.getProduct(request.getId()));
		return response;
	}
	
	@PayloadRoot(namespace = "http://details.com/product", localPart = "PostProductDetailsRequest")
	@ResponsePayload
	public PostProductDetailsResponse processProductDetailRequest(@RequestPayload PostProductDetailsRequest request)
	{
		PostProductDetailsResponse response = new PostProductDetailsResponse();
		
		response.setResponse(requests.postProduct(request.getProductDetails()));
		return response;
	}
}
