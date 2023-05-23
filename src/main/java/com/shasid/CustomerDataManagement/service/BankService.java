package com.shasid.CustomerDataManagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.shasid.CustomerDataManagement.dto.ResponseStructure;
import com.shasid.CustomerDataManagement.entity.BankAccount;
import com.shasid.CustomerDataManagement.entity.Person;
import com.shasid.CustomerDataManagement.repository.BankAccountDao;

@Service
public class BankService {
	@Autowired
	private BankAccountDao dao;
	public List<BankAccount> getByBankName(String name) {
		return dao.getByBankName(name);
	}

	public ResponseStructure<BankAccount> getByBankId(int id) {
		BankAccount account = dao.getByBankId(id);
		ResponseStructure<BankAccount> rs = new ResponseStructure<>();
		rs.setData(account);
		rs.setStatusCode(HttpStatus.ACCEPTED.value());
		rs.setTimeStamp(LocalDateTime.now());
		rs.setMessage("Successfully get the id from the BankAccount");
		return rs;
	}
	
	public BankAccount deleteByBankId(int id) {
		return dao.deleteByBankId(id);
	}
	
public ResponseStructure<List<BankAccount>> getAll() {
		
		List<BankAccount> all = dao.getAll();
		 ResponseStructure<List<BankAccount>> rs = new ResponseStructure<>();
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
	}

