package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	//http://localhost:9191/InsuranceBackendRest/myapp/customers/register
	@RequestMapping(value="/register" , method=RequestMethod.POST)
	public String signup(@RequestBody Customer customer) {
		String message = customerService.RegisterCustomer(customer);
		return message;
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody LoginDto loginData)
	{
		
		boolean isvalid=customerService.userlogin(loginData.getUserName(),loginData.getPassword());
		return isvalid;
	}

}
