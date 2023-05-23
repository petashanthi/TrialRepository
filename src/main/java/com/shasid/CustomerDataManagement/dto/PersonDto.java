package com.shasid.CustomerDataManagement.dto;

import java.io.Serializable;

import com.shasid.CustomerDataManagement.entity.Person;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDto implements Serializable {

	   
	    private Integer id;

		private String name;
		
		private String email;
		public PersonDto(Person person) {
			this.id=person.getId();
			this.name=person.getName();
			this.email=person.getEmail();
	}

}
