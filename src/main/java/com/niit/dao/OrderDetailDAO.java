package com.niit.dao;

import java.util.List;

import com.niit.model.OrderDetail;
import com.niit.model.Product;

public interface OrderDetailDAO
{
	public boolean insertOrderDetail(OrderDetail orderDetail);
	  public boolean updateOrderDetail(String username);
	  public List<OrderDetail> listorder();
}