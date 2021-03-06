package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserDetail {

	@Id
	String userName;
	String password;
	String role;  //ROLE_USER, ROLE_ADMIN
	String enabled; //TRUE | FAlse
	String customerName;
	String address;
	String email;
	String mobile;
	String Security_q;
	public String getSecurity_q() {
		return Security_q;
	}
	public void setSecurity_q(String security_q) {
		Security_q = security_q;
	}
	public String getSecurity_a() {
		return Security_a;
	}
	public void setSecurity_a(String security_a) {
		Security_a = security_a;
	}
	String Security_a;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
