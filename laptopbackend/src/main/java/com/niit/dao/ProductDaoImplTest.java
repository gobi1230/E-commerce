package com.niit.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dbconfig.DBConfiguration;
import com.niit.model.Product;
import com.niit.service.ProductService;
import com.niit.service.ProductServiceImpl;

import junit.framework.TestCase;

public class ProductDaoImplTest extends TestCase {
	ApplicationContext ac=new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class,ProductServiceImpl.class);
	ProductService pds=(ProductService)ac.getBean("productServiceImpl");

	@Test
	public void testAddProducts() {
		Product p=new Product();
		p.setProductname("CAR");
		p.setProductdesc("BENZ WHITE");
		p.setQuantity(5);
		p.setPrice(750000);
		//p.setId(5);
		pds.addProducts(p);
		assertTrue(p.getId()>0);
	}

	@Test
	public void testUpdateProducts() {
		
	}

	@Test
	public void testDeleteProducts() {
		
	}

	@Test
	public void testSelectProducts() {
		Product actualproduct1=pds.selectProducts(1);
		Product actualproduct2=pds.selectProducts(45);
		assertNotNull(actualproduct1);
		assertNull(actualproduct2);
	}

	@Test
	public void testGetAllProducts() {
		
	}

}
