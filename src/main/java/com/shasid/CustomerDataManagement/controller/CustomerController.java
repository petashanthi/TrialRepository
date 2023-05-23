package com.shasid.CustomerDataManagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shasid.CustomerDataManagement.dto.CustomerDto;
import com.shasid.CustomerDataManagement.dto.ResponseStructure;
import com.shasid.CustomerDataManagement.entity.Customer;
import com.shasid.CustomerDataManagement.service.CustomerService;
@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	@PostMapping(value="/customer")
	public @ResponseBody ResponseStructure<Customer> saveCustomer(@RequestBody CustomerDto dto) {
		return service.saveCustomer(dto);
	}
	@PutMapping("/customer")
	public @ResponseBody ResponseStructure<Customer> updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	@GetMapping(value="/customer")
	public ResponseStructure<List<Customer>> getAllCustomerData() {
		return service.getAllCustomerData();
	}
	@GetMapping("/customer/{id}")
	public  @ResponseBody  ResponseStructure<Customer> getCustomerDataById(@PathVariable("id") int id) {
		return service.getCustomerDataById(id);
	}
	@DeleteMapping("/customer")
	public  @ResponseBody ResponseStructure<Customer> deleteCustomerDataById(@RequestParam("id") int id) {
		return service.deleteCustomerDataById(id);
	}
	
	@PostMapping("/customers")
	public List<Customer> saveAllVisitorsData(List<Customer> listOfCustomers) {
		return service.saveAllCustomersData(listOfCustomers);
}
	
	@GetMapping("/customerbyname/{name}")
	public  @ResponseBody ResponseStructure<Customer> getCustomerDataByName(@PathVariable("name")  String name) {
		return service.getCustomerDataByName(name);
	}
	
	@PostMapping("/validatecustomer")
	public   List<Customer> validateCustomer(@RequestParam("name")  String name,@RequestParam("email")  String email){
		
		return service.validateCustomer(name, email);
		
	}
	
	
	}
//@requestBody
//fetch the request option