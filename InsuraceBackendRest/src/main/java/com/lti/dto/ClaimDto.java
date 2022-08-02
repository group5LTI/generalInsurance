package com.lti.dto;

import com.lti.entity.ClaimInsurance;

public class ClaimDto {

	String message;
	ClaimInsurance ins;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ClaimInsurance getIns() {
		return ins;
	}
	public void setIns(ClaimInsurance ins) {
		this.ins = ins;
	}
	
	
}
