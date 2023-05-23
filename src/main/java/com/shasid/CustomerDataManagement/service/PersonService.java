package com.shasid.CustomerDataManagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.shasid.CustomerDataManagement.dto.PersonDto;
import com.shasid.CustomerDataManagement.dto.ResponseStructure;
import com.shasid.CustomerDataManagement.entity.BankAccount;
import com.shasid.CustomerDataManagement.entity.Person;
import com.shasid.CustomerDataManagement.repository.PersonDao;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;
	
	public ResponseStructure<Person> savePerson(PersonDto dto) {
		Person person = new Person(dto);
		Person save = dao.save(person);
		ResponseStructure<Person> rs = new ResponseStructure<>();
		rs.setData(person);
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setTimeStamp(LocalDateTime.now());
		rs.setMessage("Successfullly Person data Saved In the DataBase");
		return rs;
	}
	public  ResponseStructure<Person> updatePersondAndBankAccount(Person person) {
	  Person save = dao.save(person);
	  ResponseStructure<Person> rs = new ResponseStructure<>();
	  rs.setData(save);
	  rs.setStatusCode(HttpStatus.ACCEPTED.value());
	  rs.setTimeStamp(LocalDateTime.now());
	  rs.setMessage(HttpStatus.ACCEPTED.name());
	return rs;
	}
	
	public ResponseStructure<List<Person>> getAll() {
		
		List<Person> all = dao.getAll();
		 ResponseStructure<List<Person>> rs = new ResponseStructure<>();
		 if(all.size()!=0) {
		  rs.setData(all);
		  rs.setStatusCode(HttpStatus.FOUND.value());
		  rs.setTimeStamp(LocalDateTime.now());
		  rs.setMessage("Person entry found in the data base");
		 }
		 else
		 {
			  rs.setData(null);
			  rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			  rs.setTimeStamp(LocalDateTime.now());
			  rs.setMessage(" no Person entry found in the database");
		 }
		return rs;
	}
	
	public List<Person> getAllBankAccount(List<BankAccount>  accounts) {
		return dao.getAllBankAccount(accounts);
	}
	
	
	public List<Person> getByPersonName(String name) {
		return dao.getByPersonName(name);
	}
	
	public ResponseStructure<Person> getByPersonId(int id) {
		Person person = dao.getByPersonId(id);
		ResponseStructure<Person> rs = new ResponseStructure<>();
		  rs.setData(person);
		  rs.setStatusCode(HttpStatus.ACCEPTED.value());
		  rs.setTimeStamp(LocalDateTime.now());
		  rs.setMessage(HttpStatus.ACCEPTED.name());
		return rs;
	}
	
	public ResponseStructure<Person> deleteByPersonId(int id) {
		Person person = dao.deleteByPersonId(id);
		ResponseStructure<Person> rs = new ResponseStructure<>();
		  rs.setData(person);
		  rs.setStatusCode(HttpStatus.ACCEPTED.value());
		  rs.setTimeStamp(LocalDateTime.now());
		  rs.setMessage(HttpStatus.ACCEPTED.name());
		return rs;
	}
}
