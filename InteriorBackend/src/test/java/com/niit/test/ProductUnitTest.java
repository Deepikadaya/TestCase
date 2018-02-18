package com.niit.test;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;



public class ProductUnitTest {
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(1);
		product.setSupplierId(1);
		product.setCategoryId(1);
		product.setPrice(1000);
		product.setStock(19);
		product.setProductName("The Job");
		product.setProdDesc("Colin Winnette");
		assertTrue("Problem in Category Insertion",productDAO.addProduct(product));
	}
	
	@Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in get Category",productDAO.getProduct(5));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(2);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}
    
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(1);
		product.setPrice(699);
		product.setStock(9);
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
	@Ignore
	@Test
	public void listProductTest()
	{   
		List<Product> listProducts=productDAO.getProducts();
		assertNotNull("No Products",listProducts);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getStock()+":::");
			System.out.print(product.getPrice()+":::");
			System.out.println(product.getProdDesc());
		}
	}


}
