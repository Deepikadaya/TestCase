package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.model.*;
import com.niit.dao.*;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement

public class DBConfig {
	
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/bookProject");
		dataSource.setUsername("deepika");
		dataSource.setPassword("deepi");
		
		System.out.println("---Data Source Created---");
		return dataSource;
	}
	
	//@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		
		Properties hibernateProp=new Properties();
		
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(Product.class);
		factoryBuilder.addAnnotatedClass(Supplier.class);
		factoryBuilder.addAnnotatedClass(User.class);
		factoryBuilder.addProperties(hibernateProp);
		
		System.out.println("Creating SessionFactory Bean");
		return factoryBuilder.buildSessionFactory();
	}
	
	/*
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("----Category DAO Implementation---");
		return new CategoryDAOImpl();
	}
	
	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("---Product DAO Implementation ---");
		return new ProductDAOImpl();
	}
	
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO()
	{
		System.out.println("----Supplier DAO Implementation---");
		return new SupplierDAOImpl();
	}
	
	@Bean(name="userDAO")
	public UserDAO getUserDAO()
	{
		System.out.println("----User DAO Implementation---");
		return new UserDAOImpl();
	}*/

		
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager----");
		return new HibernateTransactionManager(sessionFactory);
	}
	


}
