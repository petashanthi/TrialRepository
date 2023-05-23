package com.shasid.CustomerDataManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shasid.CustomerDataManagement.entity.BankAccount;
@Repository
public interface BankRepository extends JpaRepository<BankAccount, Integer>{

	List<BankAccount> getByName(String name);
	
	
	//List<BankAccount> deleteByName(String name);
}
