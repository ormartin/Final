package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;	
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		
		for (RateDomainModel testrate : rates) {
			if (GivenCreditScore >= testrate.getiMinCreditScore()) {
				dInterestRate = testrate.getdInterestRate();
			}
			else if(dInterestRate == 0){
				throw new RateException(testrate);
			}
		}
						

		//TODO: Filter the ArrayList...  look for the correct rate for the given credit score.
		//	Easiest way is to apply a filter using a Lambda function.
		//
		//	Example... how to use Lambda functions:
		//			https://github.com/CISC181/Lambda
		
		return dInterestRate;		
	}
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
		//p: present value
		//f: future value
		//n: number of periods
		//r: rate
		//t: compounding or not
	}
}
