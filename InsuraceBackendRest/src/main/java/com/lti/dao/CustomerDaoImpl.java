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
	public boolean login(String userName ,String password) {
        // TODO Auto-generated method stub
        String jpql = "select u from Customer u where u.userName=:uname and u.password=:pwd";
        TypedQuery<Customer> qry = em.createQuery(jpql, Customer.class);
        qry.setParameter("uname", userName);
        qry.setParameter("pwd", password);

        Customer customer;
        try {
            customer=qry.getSingleResult();
        } catch (Exception e) {
            return false;
        }return true;


    }

	@Override
	public Customer searchCustomerByUsername(String userName) {
		String jpql = "select u from Customer u where u.userName=:uname";
        TypedQuery<Customer> qry = em.createQuery(jpql, Customer.class);
        qry.setParameter("uname", userName);
        Customer customer;
        try {
            customer=qry.getSingleResult();
        } catch (Exception e) {
            return null;
        }return customer;
	}

	@Override
	public boolean searchCustomerByEmail(String mailId) {
		String jpql = "select u from Customer u where u.mailId=:umail";
        TypedQuery<Customer> qry = em.createQuery(jpql, Customer.class);
        qry.setParameter("umail", mailId);
        Customer customer;
        try {
            customer=qry.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
	}
}
