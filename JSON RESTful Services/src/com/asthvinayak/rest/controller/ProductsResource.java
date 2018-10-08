package com.asthvinayak.rest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.asthvinayak.bean.Product;
import com.asthvinayak.service.ProductService;

@Path("/products")
public class ProductsResource {

	@Context
	UriInfo uriInfo;

	@Context
	Request request;

	ProductService productService;

	public ProductsResource() {
		productService = new ProductService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Product> getProductsJson() {
		return productService.getProductAsList();
	}

	@GET
	@Path("/json")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Product> getProducts() {
		return productService.getProductAsList();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/xml")
	public List<Product> getProductsAsHtml() {
		return productService.getProductAsList();
	}

	// URI: /rest/products/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(productService.getProductsCount());
	}

	@POST
	@Path("form")
	public void createProduct(@FormParam("id") String id, @FormParam("productname") String name,
			@FormParam("productcategory") String category, @Context HttpServletResponse servletResponse)
			throws IOException {
		Product product = new Product(id, name, category);
		productService.createProduct(product);
		servletResponse.sendRedirect("./products/");
	}

	@GET
	@Path("{product}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductAsHtml(@PathParam("product") String id) {
		Product product = productService.getProduct(id);
		return product;
	}

}