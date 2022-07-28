package com.lti.service;

import com.lti.entity.Customer;

public interface CustomerService {

	String RegisterCustomer(Customer newCustomer);
	Customer findcustomerById(int userId);
	boolean userlogin(String string,String password);
}
