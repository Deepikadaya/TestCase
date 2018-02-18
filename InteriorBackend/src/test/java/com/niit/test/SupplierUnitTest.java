package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Product;
import com.niit.model.Supplier;

public class SupplierUnitTest {
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("True Retailer");
		supplier.setSupplierLocation("Chennai");
	    assertTrue("Problem in Supplier Insertion",supplierDAO.addSupplier(supplier));
	}
	
	/*@Ignore
	@Test
	public void getSupplierTest()
	{
		assertNotNull("Problem in get Supplier",supplierDAO.getSupplier(2));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(2);
		assertTrue("Problem in Deletion:",supplierDAO.deleteSupplier(supplier));
	}
	*/
	
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(1);
	    supplier.setSupplierId(1);
		supplier.setSupplierName("FasterTheSeller");
		assertTrue("Problem in Updation",supplierDAO.updateSupplier(supplier));
	}
	
	/*@Ignore
	@Test
	public void listSupplierTest()
	{
		List<Supplier> listSuppliers=supplierDAO.getSupplier();
		assertNotNull("No Suppliers",listSuppliers);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getSupplierId()+":::");
			System.out.print(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierLocation());
		}
	}
	*/
    
	

}
