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

import com.shasid.CustomerDataManagement.dto.PersonDto;
import com.shasid.CustomerDataManagement.dto.ResponseStructure;
import com.shasid.CustomerDataManagement.entity.BankAccount;
import com.shasid.CustomerDataManagement.entity.Person;
import com.shasid.CustomerDataManagement.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;
	
	@PostMapping("/person")
	public ResponseStructure<Person> save(@RequestBody  PersonDto person) {
		return service.savePerson(person);
	}
	@PutMapping("/person")
	public @ResponseBody ResponseStructure<Person> updatePersonAndBankAccount( @RequestBody    Person person) {
		return service.updatePersondAndBankAccount(person);
	}
	@GetMapping("/person")
	public @ResponseBody ResponseStructure<List<Person>> getAll() {
		return service.getAll();
	}
	@GetMapping("/bankaccount")
	public  @ResponseBody List<Person> getAllBankAccount(List<BankAccount>  accounts) {
		return service.getAllBankAccount(accounts);
	}
	@GetMapping("/person/{name}")
	public   @ResponseBody List<Person> getByPersonName( @PathVariable("name")   String name) {
		return service.getByPersonName(name);
	}
	@GetMapping("/personid")
	public ResponseStructure<Person> getBYPersonId( @RequestParam("id") int id) {
		return service.getByPersonId(id);
	}
	@DeleteMapping("/person")
	public ResponseStructure<Person> deleteByPersonId(@RequestParam  int id) {
		return service.deleteByPersonId(id);
	}
	
}
