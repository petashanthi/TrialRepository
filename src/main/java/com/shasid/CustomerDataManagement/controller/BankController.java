package com.shasid.CustomerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shasid.CustomerDataManagement.dto.ResponseStructure;
import com.shasid.CustomerDataManagement.entity.BankAccount;
import com.shasid.CustomerDataManagement.entity.Person;
import com.shasid.CustomerDataManagement.service.BankService;

@RestController
public class BankController {

	@Autowired
	private BankService service;
	@GetMapping("/getByBankName/{name}")
	public List<BankAccount> getByBankName(@PathVariable("name")  String name) {
		return service.getByBankName(name);
	}
	
	@GetMapping("/bankid")
	public ResponseStructure<BankAccount> getByBankId(@RequestParam("id")  int id) {
		return service.getByBankId(id);
	}
	@DeleteMapping("/bankaccount")
	public BankAccount deleteByBankId(@RequestParam("id")  int id) {
	return service.deleteByBankId(id);
	}
	@GetMapping("/bank")
	public ResponseStructure<List<BankAccount>> getAll() {
		return service.getAll();
		
	}
}
