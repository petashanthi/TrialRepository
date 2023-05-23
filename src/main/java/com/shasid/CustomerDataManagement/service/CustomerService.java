package com.shasid.CustomerDataManagement.service;

import java.time.LocalDateTime;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.shasid.CustomerDataManagement.dto.CustomerDto;
import com.shasid.CustomerDataManagement.dto.ResponseStructure;
import com.shasid.CustomerDataManagement.entity.Customer;
import com.shasid.CustomerDataManagement.repository.CustomerDao;
import com.shasid.CustomerDataManagement.repository.CustomerRepository;
@Service
public class CustomerService {

	
	@Autowired
	private CustomerDao dao;
	//@Qualifier("dao2")
	
	public ResponseStructure<Customer> saveCustomer(CustomerDto dto) {
		Customer cus = new Customer(dto);
		 Customer customer = dao.saveCustomer(cus);
		 
		 ResponseStructure<Customer> rs = new ResponseStructure<>();
		 rs.setData(customer);
		 rs.setStatusCode(HttpStatus.OK.value());
		 rs.setTimeStamp(LocalDateTime.now());
		 rs.setMessage("Customer data saved successfully");
		 return rs;
	}
	public  ResponseStructure<Customer> updateCustomer(Customer customer) {
		 Customer cus = dao.saveCustomer(customer);
		 ResponseStructure<Customer> rs = new ResponseStructure<>();
		 rs.setData(cus);
		 rs.setStatusCode(HttpStatus.ACCEPTED.value());
		 rs.setTimeStamp(LocalDateTime.now());
		 rs.setMessage(HttpStatus.ACCEPTED.name());
		 return rs;
	}
	public ResponseStructure<List<Customer>> getAllCustomerData() {
		List<Customer> list = dao.getAllCustomerData();
		ResponseStructure<List<Customer>> structure = new ResponseStructure<>();
		if(list.size()!=0) {
			
			structure.setData(list);
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setTimeStamp(LocalDateTime.now());
			structure.setMessage("Customer entry found in the database");
		}
		else
		{
			structure.setData(null);
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setTimeStamp(LocalDateTime.now());
			structure.setMessage(" No Customer entry found in the database");
			
		}
		return structure;
	}
	
	public ResponseStructure<Customer> getCustomerDataById(int id) {
		
		Customer customer = dao.getCustomerDataById(id);
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		structure.setData(customer);
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("Successfully Get The Id From The Customer");
		return structure;
		
	}
	public ResponseStructure<Customer> deleteCustomerDataById(int id) {
		
		
		Customer customer = dao.deleteCustomerDataById(id);
		
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		structure.setData(customer);
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("Successfully Deleted The Data By Using Id From The Customer");
		return structure;
	}
	public List<Customer> saveAllCustomersData(List<Customer> listOfCustomers) {
		return dao.saveAllCustomersData(listOfCustomers);
	}
	
	
	public ResponseStructure<Customer> getCustomerDataByName(String name) {
		List<Customer> byName = dao.getCustomerByName(name);
		Customer customer = new Customer();
		ResponseStructure<Customer> rs = new ResponseStructure<>();
		rs.setData(customer);
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setTimeStamp(LocalDateTime.now());
		rs.setMessage("Successfully get by the name from the Customer");
		return rs;
		}
	
	public List<Customer> validateCustomer(String name,String email) {
		
		return dao.validateCustomer(name, email);
	}
	
	
	}

//same the method it will be used the save the data and update the data.