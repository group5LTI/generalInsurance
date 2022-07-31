package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerDao;
import com.lti.dto.UpdateCustomer;
import com.lti.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;

	@Autowired
	EmailService emailService;
	public String RegisterCustomer(Customer newCustomer) {
		Customer customer;
		try {
			customer = customerDao.addOrUpdateCustomer(newCustomer);
			
			String email=customer.getMailId();
			String text = "Registration Successful. Your user id is "+customer.getUserId();
			String subject = "Registration Confirmation";
			emailService.sendEmailForSignup(email, text, subject);
			System.out.println("Email Sent");
			return "Sign Up Successful Your UserId:"+customer.getUserId();
		} catch (Exception e) {
			return e.getMessage();
		}
		

	}
	
	
	public UpdateCustomer updateProfile(Customer customer)
    {
        UpdateCustomer updateCustomer=new UpdateCustomer();
        try {
            Customer cust2=customerDao.addOrUpdateCustomer(customer);
            updateCustomer.setMessage("profile updated");
            updateCustomer.setCustomer(cust2);
            return updateCustomer;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            updateCustomer.setMessage(e.getMessage());
            return updateCustomer;
        }
    }

	@Override
	public Customer findcustomerById(int userId) {
		return customerDao.searchCustomer(userId);
		
	}

	@Override
	public boolean userlogin(String userName, String password) {
		return customerDao.login(userName, password);
	}

	 @Override
	    public Customer searchUserByUsername(String userName) {
	        // TODO Auto-generated method stub
	        return customerDao.searchCustomerByUsername(userName);
	    }

	@Override
	public boolean searchUserByMailId(String mailId) {
		// TODO Auto-generated method stub
		return customerDao.searchCustomerByEmail(mailId);
	}



	@Override
	public Customer searchCustomerByuserId(int userId) {
		// TODO Auto-generated method stub
		return customerDao.searchCustomer(userId);
	}


	@Override
	public Customer searchCustomerByVehicleId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
