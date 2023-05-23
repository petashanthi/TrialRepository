package com.shasid.CustomerDataManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shasid.CustomerDataManagement.entity.BankAccount;
import com.shasid.CustomerDataManagement.entity.Customer;
import com.shasid.CustomerDataManagement.entity.Person;
@Repository
public interface PersonRepository  extends JpaRepository<Person,Integer>{

	List<Person> getByName(String name);
	
	// List<BankAccount>  deleteByName(String name);
}
