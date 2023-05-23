package com.shasid.CustomerDataManagement.dto;

import java.io.Serializable;

import com.shasid.CustomerDataManagement.entity.Customer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDto  implements Serializable{

	private Integer id;
	
    private String name;
	
	private String email;
	
	public CustomerDto (Customer customer) {
		this.id=customer.getId();
		this.name=customer.getName();
		this.email=customer.getEmail();
		
	}
}
