package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
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
private SessionFactory sf;
	
	
	public ProductDaoImpl(){
		System.out.println("ProductDaoImpl bean is created");
	}
	
	public void addProduct(Product product) {
		Session session=sf.openSession();
		session.save(product);
		session.flush();
	}
	
	public void updateProduct(Product product) {
		Session session=sf.openSession();
		session.update(product);
		session.flush();
	}

	public void deleteProducts(int id) {
		Session  s = sf.openSession();
		
		 Product p=(Product)s.get(Product.class,id);
		 if(p != null)
		 {
			 try{
				 s.delete(p);
		 System.out.println("--------------------------------------------------------------------------------------------------------");
		 System.out.println("RECORD DELETED SUCCESSFULLY");
		 }
		 catch(Exception e)
		 {
				e.printStackTrace();

		 }
		 }
		 else
		 {
			 System.out.println("--------------------------------------------------------------------------------------------------------");
				System.out.println("RECORD DELETION FAILED");
		 }
	
	s.flush();
		
	}

	public Product selectProducts(int id) {
		Session  s = sf.openSession();
		//************************************************** SELECTION THROUGH GET() METHOD ************************************************************
		
			 Object obj=(Object)s.get(Product.class,id);
			 Product p=(Product)obj;
			 if(p!=null)
			 {

				 System.out.println("");
				 System.out.println("************************************************** SELECTION THROUGH GET() METHOD ************************************************************");
				 System.out.println("--------------------------------------------------------------------------------------------------------");
				 System.out.println("PRODUCT ID"+"\t"+"PRODUCT NAME"+"\t"+"PRODUCT DESCRIPTION"+"\t"+"PRODUCT PRICE"+"\t"+"PRODUCT QUANTITY");
				 System.out.println("--------------------------------------------------------------------------------------------------------");
				 System.out.println(p.getId()+"\t\t"+p.getProductname()+"\t\t"+p.getProductdesc()+"\t\t"+p.getPrice()+"\t\t"+p.getQuantity());
				 System.out.println("--------------------------------------------------------------------------------------------------------");
				 System.out.println("RECORD RETRIEVED SUCCESSFULLY");
			 }
			else
				{
					
					System.out.println("RECORD RETRIEVAL FAILED");
				}
			 s.flush();
			 return p;

	}

	public List<Product> getAllProducts() {
		Session session=sf.openSession();
		Query query	=session.createQuery("from Product");
		List<Product> product=query.list();
	return product;

		
	}
}
