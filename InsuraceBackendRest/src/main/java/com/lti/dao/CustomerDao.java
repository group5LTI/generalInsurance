package com.lti.dao;

import java.util.List;

import com.lti.entity.Customer;

public interface CustomerDao {

	Customer addOrUpdateCustomer(Customer customer);
	Customer searchCustomer(int customerId);
	Customer searchCustomerByUsername(String userName);
	boolean searchCustomerByEmail(String mailId);
	List<Customer> viewAllCustomers();
	boolean login(String userName,String password);
}
