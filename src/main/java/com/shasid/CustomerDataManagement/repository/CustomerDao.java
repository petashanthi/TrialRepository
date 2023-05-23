package com.shasid.CustomerDataManagement.repository;
//service layer and repository interface object

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.shasid.CustomerDataManagement.entity.Customer;
@Repository
//22/05/2023
@Qualifier("dao")
public class CustomerDao {
	@Autowired
    private CustomerRepository repository;
	
	{
		System.err.println("Customerdao:");
	}
	
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);

	}
	public List<Customer> getAllCustomerData() {
	return 	repository.findAll();
	}
	public Customer getCustomerDataById(int id) {
		 return repository.findById(id).orElse(new Customer(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name()));
	}
	public Customer deleteCustomerDataById(int id) {
		Customer customer = getCustomerDataById(id);
		if(customer.getId()!=404) {
			repository.deleteById(id);
		}
		return customer;
	}
	public List<Customer> saveAllCustomersData(List<Customer> listOfCustomers) {
		return repository.saveAllAndFlush(listOfCustomers);
	
	
	
}
	
	public List<Customer> getCustomerByName(String name) {
		return repository.findByName(name);
	}
	
	public List<Customer> validateCustomer(String name,String email) {
		return repository.validateCustomer(name, email);
	}
}
