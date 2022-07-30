package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginDto;
import com.lti.entity.Customer;
import com.lti.service.CustomerService;


@RestController
@RequestMapping("/customers")
@CrossOrigin(origins="*")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	//http://localhost:9090/InsuranceBackendRest/myapp/customers/register
	@RequestMapping(value="/register" , method=RequestMethod.POST)
	public boolean signup(@RequestBody Customer customer) {
		Customer c = customerService.searchUserByUsername(customer.getUserName());
		if(c==null) {
		String message = customerService.RegisterCustomer(customer);
		return true;
	}
		else {
			return false;
		}
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody LoginDto loginData)
	{
		
		boolean isvalid=customerService.userlogin(loginData.getUserName(),loginData.getPassword());
		return isvalid;
	}
	@GetMapping("/customer")
	public Customer searchCustomerByUsername(@RequestParam("userName") String uName) {
		return customerService.searchUserByUsername(uName);
	}
	
	@PutMapping("/update")
	public boolean updateProfile(@RequestBody Customer customer) {
		try {
			String c = customerService.updateProfile(customer);
			System.out.println(c);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	

}}
