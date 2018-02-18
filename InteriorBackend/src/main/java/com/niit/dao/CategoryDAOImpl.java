package com.niit.dao;

import java.util.List;
import com.niit.model.Category;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	public CategoryDAOImpl()
	{
		System.out.println("category object");
	}
	@Autowired
	SessionFactory sessionFactory;
	
	//addCategory
	@Transactional
	@Override
	public boolean addCategory(Category category) 
	{	
		try
		{
		sessionFactory.getCurrentSession().save(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	//getCategory()
	@Override
	public Category getCategory(int categoryId) 
	{
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryId);
		session.close();
		return category;
	}

	//deleteCategory()
	@Transactional
	@Override
	public boolean deleteCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}
	
	//updateCategory()
	@Transactional
	@Override
	public boolean updateCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	
	}

	//listCategories()	
	@Override
	public List<Category> getCategories() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategories=(List<Category>)query.list();
		return listCategories;
		
	}
}


