package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.OrderDetailDAO;
import com.niit.model.OrderDetail;
import com.niit.model.Product;

public class OrderDetailDAOTestCase {

	static OrderDetailDAO orderDetailDAO;
	
	@BeforeClass
	public static void configure(){
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		orderDetailDAO=(OrderDetailDAO)context.getBean("orderDetailDAO");
		List<OrderDetail> listorder=orderDetailDAO.listorder();
		//assertTrue("Problem in list orderdetails",listorder.size()>0);
	
		for(OrderDetail orderDetail:listorder){
			System.out.println(orderDetail.getOrderId()+"::");
			System.out.println(orderDetail.getOrderDate()+"::");
			System.out.println(orderDetail.getPaymentMode()+"::");
			System.out.println(orderDetail.getTotalPurchaseAmount()+"::");
			System.out.println(orderDetail.getUsername()+"::");
		}
}		
	
	@Ignore
	@Test
	public void insertOrderDetailTest(){
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setUsername("q");
		orderDetail.setTotalPurchaseAmount(45000);
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setPaymentMode("CC");
		
		assertTrue("Problem in inserting OrderDetail:",orderDetailDAO.insertOrderDetail(orderDetail));
	}
	@Ignore
	@Test
	public void updateCartItemsStatus(){
		assertTrue("Problem in updating cart items",orderDetailDAO.updateOrderDetail("garvit"));
	}
	
	@Test
	public void listCarttest() {
	/*List<OrderDetail> listorder=orderDetailDAO.listorder();
		assertTrue("Problem in list orderdetails",listorder.size()>0);
		for(OrderDetail orderDetail:listorder){
			System.out.println(orderDetail.getOrderId()+"::");
			System.out.println(orderDetail.getPaymentMode()+"::");
			System.out.println(orderDetail.getTotalPurchaseAmount()+"::");
		}
*/	}
}