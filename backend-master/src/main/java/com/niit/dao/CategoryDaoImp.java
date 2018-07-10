package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

//import org.h2.engine.Session;

//import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.modal.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImp implements CategoryDao {
	
	@Autowired 
	SessionFactory sessfact;
	public boolean addCategory(Category cat) {
		
			sessfact.getCurrentSession().save(cat);
			return true;
		
	}

	public boolean updateCategory(Category cat) {
		try {
			sessfact.getCurrentSession().update(cat);
			return true;
		}
		catch(Exception e) {
		return false;
	}	}

	public boolean DeleteCategory(Category cat) {
		try {
			sessfact.getCurrentSession().delete(cat);
			return true;
		}
		catch(Exception e) {
		return false;
	}	}

	public Category getCategory(int CategoryId) {
		try {
			Session sess=sessfact.getCurrentSession();
			Category cat=(Category)sess.get(Category.class, CategoryId);
			//sess.close();
			return cat;
		}
		catch(Exception e) {
			return null;
		}
	}

	public List<Category> listcateg() {
		try {
			Session session=sessfact.getCurrentSession();
			Query query=session.createQuery("from Category");
			List<Category>listCategories=query.list();
			return listCategories;
		}
		catch(Exception e) {
			return null;
		}
	}

}
