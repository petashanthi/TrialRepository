package com.shasid.CustomerDataManagement.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class BankAccount  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="p_id")
	private Integer pId;
	
	
	private String name;
	
	@Column(name="account_numbeter")
	private Long accountNumber;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="person")
	private Person person;

}
