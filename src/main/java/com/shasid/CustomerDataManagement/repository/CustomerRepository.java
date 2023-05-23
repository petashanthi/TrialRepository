package com.shasid.CustomerDataManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shasid.CustomerDataManagement.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	//to create a Custom method By using FindBy.
	List<Customer> findByName(String name);
	
	@Query("SELECT c FROM Customer c WHERE c.name=:name AND c.email=:email ")
	List<Customer> validateCustomer(@Param("name") String  name,@Param("email") String email);
}
