package com.niit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductTest 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		
		Product product=new Product();
		product.setProductName("The Curel Prince");
		product.setProdDesc("The Holy black");
		
		productDAO.addProduct(product);
		
		
	}
}

