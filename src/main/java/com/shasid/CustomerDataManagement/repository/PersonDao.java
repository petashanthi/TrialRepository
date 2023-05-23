package com.shasid.CustomerDataManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shasid.CustomerDataManagement.entity.BankAccount;
import com.shasid.CustomerDataManagement.entity.Person;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository repository;
	
	public Person save(Person person) {
		return repository.save(person);
	}
	
	public  List<Person> getAll() {
		return repository.findAll();
	}
	
	public List<Person> getAllBankAccount(List<BankAccount>  accounts) {
		return repository.findAll();
	}
	
	
	public List<Person> getByPersonName(String name) {
		return repository.getByName(name);
	}
	public Person getByPersonId(int id) {
		return repository.findById(id).orElse(new Person());
	}
	
	public Person deleteByPersonId(int id) {
		Person person = getByPersonId(id);
		if(person!=null) {
			repository.deleteById(id);
		}
		return person;
		
	}
}
