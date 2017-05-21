package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {
	//gets all rates, sees amount of rates, makes sure size is greater than 0

	@Test
	public void ratetest(){
		ArrayList<RateDomainModel> ratetest1 = RateDAL.getAllRates();
		int size = ratetest1.size();
		assertTrue(size > 0);
	}
}