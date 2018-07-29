package com.niit.dao;

import org.hibernate.Session;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.OrderDetail;

@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
    
	public boolean insertOrderDetail(OrderDetail orderDetail)
	{
    	try
    	{
    		sessionFactory.getCurrentSession().save(orderDetail);
    		return true;
    	}

    	catch(Exception e)
    	{
    		return false;
    		
    	}
	}
    public boolean updateOrderDetail(String username)
    {
    	try
    	{
    		Session session=sessionFactory.openSession();
    		Query query=session.createQuery("update CartItem set Status='p' where username=:myusername and status='NA'");
    		query.setParameter("myusername", username);
    		int row_eff=query.executeUpdate();
    		if(row_eff>0)
    			return true;
    			else
    				return  false;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
	public List<OrderDetail> listorder() {
		try{
			Session session=sessionFactory.openSession();
			System.out.println("1");
			Query query=session.createQuery("From OrderDetail");
			System.out.println("2");
			List<OrderDetail> listorder=query.list();
			System.out.println("3");
			for(OrderDetail orderDetail:listorder){
					System.out.println(orderDetail.getOrderId()+"::");
					System.out.println(orderDetail.getOrderDate()+"::");
					System.out.println(orderDetail.getPaymentMode()+"::");
					System.out.println(orderDetail.getTotalPurchaseAmount()+"::");
					System.out.println(orderDetail.getUsername()+"::");
				}

			
			session.close();
			return listorder;
		}
		catch(Exception e){
	
		return null;
		}
	}

}
	
	

