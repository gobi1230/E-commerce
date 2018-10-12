package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
private SessionFactory sessionFactory;
	
	
	public ProductDaoImpl(){
		System.out.println("ProductDaoImpl bean is created");
	}
	
	public void addProduct(Product product) {
		Session session=sessionFactory.openSession();
		session.save(product);
		session.flush();
	}
	
	public void updateProduct(Product product) {
		Session session=sessionFactory.openSession();
		session.update(product);
		session.flush();
	}
}
