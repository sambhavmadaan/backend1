package com.niit.dao;

import java.util.List;

import com.niit.modal.Category;

public interface CategoryDao {
	public boolean addCategory(Category cat);
	public boolean updateCategory(Category cat);
	public boolean DeleteCategory(Category cat);
	
	public Category getCategory(int CategoryId);
	public List<Category> listcateg();
}
