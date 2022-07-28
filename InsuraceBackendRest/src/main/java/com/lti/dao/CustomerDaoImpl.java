package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.Customer;

@Component
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Customer addOrUpdateCustomer(Customer customer) {
		Customer customerPersisted = null;
		try {
			customerPersisted = em.merge(customer);
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return customerPersisted;
	}

	public Customer searchCustomer(int customerId) {
		// TODO Auto-generated method stub
		return em.find(Customer.class, customerId);
	}

	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub

		//return em.createQuery("select c from tbl_customer c", Customer.class).getResultList();
		String jpql="select c from Customer c";
		TypedQuery<Customer> query=em.createQuery(jpql,Customer.class);
		return query.getResultList();
		
	}
	public boolean login(int userId, String password) {
		String jpql="select c from Customer c where c.userId=:cid and c.password=:pwd";
		TypedQuery<Customer> query=em.createQuery(jpql,Customer.class);
		query.setParameter("cid", userId);
		query.setParameter("pwd", password);
		Customer customer=query.getSingleResult();
		return customer!=null?true:false;

		

	}

}
