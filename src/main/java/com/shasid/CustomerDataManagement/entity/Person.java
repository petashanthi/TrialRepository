package com.shasid.CustomerDataManagement.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.shasid.CustomerDataManagement.dto.PersonDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Person implements Serializable {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	
	private String name;
	
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "person")
	private List<BankAccount>  accounts;
	 
	public Person(PersonDto dto) {
		this.id=dto.getId();
		this.name=dto.getName();
		this.email=dto.getEmail();
	}
	

}
