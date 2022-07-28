package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;

	public String RegisterCustomer(Customer newCustomer) {
		Customer customer;
		try {
			customer = customerDao.addOrUpdateCustomer(newCustomer);
		} catch (Exception e) {
			return "SignUp Failed";
		}
		return "Sign Up Successful Your UserId:"+customer.getUserId();
	}
	
	
}
