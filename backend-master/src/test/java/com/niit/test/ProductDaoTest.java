package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.modal.Category;
import com.niit.modal.Product;

public class ProductDaoTest {
	static ProductDao productDao;
	@BeforeClass
	public static void executeFirst(){
		System.out.println("we are in execute first method");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
			productDao =(ProductDao)context.getBean("productDao" );
			//Product product=new Product();
//			product.setProdName("Samsung note");
//			product.setProdDesc("Samsung Mobile");
//			product.setPrice(530000);
//			product.setStock(120);
//			product.setCategoryId(2);
//			product.setSuppId(2);
//			productDao.addProduct(product);
//		System.out.println("we are in delete product test case");
//		Product product=productDao.getProduct(65);
//		System.out.println(product.getProdId());
//		System.out.println(product.getProdName());
//		System.out.println(product.getProdDesc());
//		productDao.deleteProduct(product);
			List<Product> listProduct=productDao.listprod();
			//assertTrue("Problem in list categories",listProduct.size()>0);
			for(Product product:listProduct){
				System.out.println(product.getProdId()+"::");
				System.out.println(product.getProdName()+"::");
				System.out.println(product.getProdDesc()+"::");
	}
	}
	   @Ignore
	@Test
	public void addProductTestCase(){
				
//		assertTrue("Problem in adding product",productDAO.addProduct(product));
	}
	
@Ignore
	@Test
	public void deleteProductTest(){
		
		//assertTrue("problem in deleting",productDao.deleteProduct(product));
	}

	@Test
	public void listProductTest(){
		
		}
}

