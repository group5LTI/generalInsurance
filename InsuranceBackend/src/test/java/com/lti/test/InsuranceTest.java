package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.InsuranceDao;
import com.lti.dao.TravelInsuranceDao;
import com.lti.dao.VehicleInsuranceDao;
import com.lti.entity.Insurance;
import com.lti.entity.TravelInsurance;
import com.lti.entity.VehicleInsurance;

public class InsuranceTest {

	InsuranceDao dao;
	VehicleInsuranceDao daovi;
	TravelInsuranceDao daoti;

	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(InsuranceDao.class);
		daovi = context.getBean(VehicleInsuranceDao.class);
		daoti = context.getBean(TravelInsuranceDao.class);
	}

	// tested for 7002 -->11002 , 5001 -->11003
	@Test
	public void insuranceAddTest() {
		Insurance i = new Insurance();
		VehicleInsurance vi = daovi.searchVehicleInsuraceById(7002);
		i = vi.getInsurance();

//		TravelInsurance ti = daoti.searchTravelInsuranceById(5001);
//		i = ti.getInsurance();
		Insurance insurance = new Insurance();
		if (i == null) {
			i.setVehicleInsurance(vi);
//			i.setTravelInsurance(ti);
			insurance = dao.addInsurance(i);
			assertNotNull(insurance);
		} else {
			System.out.println("Record already exist");
		}

	}

	// tested
	@Test
	public void viewallInusrances() {
		List<Insurance> insurances = dao.viewAllInsurances();
		assertNotEquals(0, insurances.size());

	}

	// tested
	@Test
	public void viewInsurancesUsingVehicleId() {
		Insurance i = new Insurance();
		VehicleInsurance vi = daovi.searchVehicleInsuraceById(7002);
		i = vi.getInsurance();
		System.out.println(i.getInsuranceId());
		assertNotNull(i);

	}

	// tested
	@Test
	public void viewInsurancesUsingTravelId() {
		Insurance i = new Insurance();
		TravelInsurance ti = daoti.searchTravelInsuranceById(5001);
		i = ti.getInsurance();
		System.out.println(i.getInsuranceId());
		assertNotNull(i);

	}

}
