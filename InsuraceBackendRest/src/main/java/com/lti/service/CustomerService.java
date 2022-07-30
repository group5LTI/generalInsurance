package com.lti.service;

import com.lti.entity.Customer;

public interface CustomerService {

	String RegisterCustomer(Customer newCustomer);
	Customer searchUserByUsername(String userName);
	Customer searchCustomerByuserId(int userId);
	boolean searchUserByMailId(String mailId);
	Customer findcustomerById(int userId);
	boolean userlogin(String string,String password);
	String updateProfile(Customer c);
}
