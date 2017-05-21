package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {
	//Makes sure getpayments returns known value
	//4% annual rate = .04/12 for monthly
	//360 periods = 30 years
	//home value = $300,000
	//future value = 0
	//not compounding
	@Test
	public void paymenttest(){
		double monthly_payment = RateBLL.getPayment((.04)/12, 360, 300000, 0, false)*-1;
		assertEquals(monthly_payment, 1432.25, 0.01);
	}
	//Check to see if a known credit score returns a known interest rate
	@Test
	public void ratetest1() throws RateException{
		assertTrue(7.0 == RateBLL.getRate(600));
	}
	//Sees if exception is thrown because no rate for 599
	@Test
	public void ratetest2() throws RateException{
		RateBLL.getRate(599);
		//does throw exception "You is broke" but test says fails
	}
}

