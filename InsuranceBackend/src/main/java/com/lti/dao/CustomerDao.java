package com.lti.dao;

import java.util.List;

import com.lti.entity.Customer;

public interface CustomerDao {

	Customer addOrUpdateCustomer(Customer customer);
	Customer searchCustomer(int customerId);
	List<Customer> viewAllCustomers();
}
