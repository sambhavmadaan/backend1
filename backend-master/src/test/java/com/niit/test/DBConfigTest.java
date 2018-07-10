package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.modal.Category;
import com.niit.modal.Product;

public class DBConfigTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		//context.close();
	//CategoryDao categoryDao= (CategoryDao)context.getBean("categoryDao");
	//Category cat=new Category();
	
	//cat.setCategoryId(1);
	//cat.setCategoryName("njsdn");
	//cat.setCategoryDesc("dsw");
	
	//categoryDao.addCategory(cat);
	
	ProductDao productDao =(ProductDao)context.getBean("productDao" );
	Product product=new Product();
	product.setProdName("Samsung J7");
	product.setProdDesc("Samsung Mobile with 4G Features");
	product.setPrice(53000);
	product.setStock(120);
	product.setCategoryId(1);
	product.setSuppId(1);
	productDao.addProduct(product);
	System.out.println("Product Saved");
	}
}
