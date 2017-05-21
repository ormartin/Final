package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	//Add RateDomainModel as an attribute
	private RateDomainModel rate;
	
	//Constructor for passing in RateDomainModel
	public RateException(RateDomainModel rate){
		this.rate = rate;	
		System.out.println("You is broke");
	}
	
	public RateException(){
		}
	//Create a getter (Alt + Shift + S)
	public RateDomainModel getRate() {
		return rate;
	}
	
}
