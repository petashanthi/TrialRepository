package com.shasid.CustomerDataManagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shasid.CustomerDataManagement.entity.BankAccount;
import com.shasid.CustomerDataManagement.entity.Person;

@Repository
public class BankAccountDao {

	@Autowired
	private BankRepository repository;
	
	public List<BankAccount> getByBankName(String name) {
		return repository.getByName(name);
	}
	
	public BankAccount getByBankId(int id) {
		return repository.findById(id).orElse(new BankAccount());
	}
	
	public BankAccount deleteByBankId(int id) {
		 BankAccount account = getByBankId(id);
		 if(account!=null){
			 repository.deleteById(id);
		 }
		return account;
	}

	public List<BankAccount> getAll() {
		return repository.findAll();
	}
}
