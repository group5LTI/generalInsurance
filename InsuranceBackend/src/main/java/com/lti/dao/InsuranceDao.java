package com.lti.dao;

import com.lti.entity.Insurance;

public interface InsuranceDao {

	Insurance addInsurance(Insurance insurance);
	
	Insurance searchInsurance(int insuranceId);
}
