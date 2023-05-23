package com.shasid.CustomerDataManagement.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private Integer statusCode;
	
	private T data;
	
	private String message;
	
	private LocalDateTime timeStamp;

}
