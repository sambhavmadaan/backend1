package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.modal.Category;

public class CategoryDaoTest {

	static CategoryDao categoryDao;
	
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
		
				//if (categoryDao == null) {
		
			//System.out.println("NULL");
		//}
List<Category> listCategories=categoryDao.listcateg();
		categoryDao.listcateg();
		for(Category categ:listCategories) {
			System.out.println(categ.getCategoryId());
			}
	}
	@Ignore
	@Test
	public void addCategoryTest() {
	Category category = new Category();
		
		category.setCategoryName("Mobile");
		category.setCategoryDesc("Oppo");
		categoryDao.addCategory(category);
		System.out.println("added");

		// Category category= new Category();
		 assertTrue("Problem in adding category",categoryDao.addCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest() {
		Category cat=categoryDao.getCategory(36);
		cat.setCategoryName("Samsung");
		cat.setCategoryDesc("4g");
		categoryDao.updateCategory(cat);
		//assertTrue("Problem in adding category",categoryDao.updateCategory(cat));
	}
	@Ignore
	@Test
	public void DeleteCategoryTest() {
		
		//assertTrue("Problem in deleting category",categoryDao.DeleteCategory(cat));
	}
	@Test
	public void listCategoriesTest() {
//		List<Category> listCategories=categoryDao.listcateg();
//		
//		for(Category categ:listCategories) {
//			System.out.println(categ.getCategoryId());
			
		}
	}

