package com.niit.test;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;


public class CategoryUnitTest {
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("History");
		category.setCategoryDesc("Fantasy is a genre that uses magic and other supernatural forms as a primary element of plot, theme, and/or setting.");
	    assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void getCategoryTest()
	{
		assertNotNull("Problem in get Category",categoryDAO.getCategory(2));
	}
	
	/*@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
	}*/
    
	
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(1);
		category.setCategoryId(1);
		category.setCategoryName("Fantasy");
		assertTrue("Problem in Updation",categoryDAO.updateCategory(category));
	}
	
	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.getCategories();
		assertNotNull("No Categories",listCategories);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc());
		}
	}


	
}




