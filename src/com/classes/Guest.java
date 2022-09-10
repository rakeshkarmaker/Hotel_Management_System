package com.classes;

import java.lang.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Guest
{
	//CheckOutCalculator obj = new CheckOutCalculator();
	protected String guestName,guestPhoneNumber,guestGender,guestAddress,guestAgeType;

	protected float guestTotalCost;
	protected String checkOutDateString,checkInDateString;

	/*public void setTotalCostCalculator(CheckOutCalculator obj){
		this.obj = obj;

	}	public CheckOutCalculator getTotalCostCalculator(){  return obj; }

*/
	public Guest(){}
	public Guest(String guestName){
		this.guestName =guestName;

	}
	public void SetCheckInTime(int daysOfStay) { //Will set the default check in time which is now and add the days of stay and set the checkout date and time.
		LocalDate checkInDate = LocalDate.now(); //OUTPUT: 2022-02-02
		//LocalTime checkInTime = LocalTime.now(); //Local Time: 7:30
		checkInDateString = checkInDate.format(DateTimeFormatter.ISO_DATE); //Converting to string

		LocalDate checkOutDate = checkInDate.plusDays(daysOfStay);
		//LocalTime checkOutTime = LocalTime.of(12,00);

		 checkOutDateString = checkOutDate.format(DateTimeFormatter.ISO_DATE); //Converting to string

	} public  String getCheckOutTime() {return checkOutDateString;}
	public  String getCheckInTime() { //returns expected checkindate

		return checkInDateString;
	}
	
	public void setGuestName(String guestName)
	{
		this.guestName=guestName;
	}
	public String getGuestName()
	{
		return guestName;
	}

	public void setGuestPhoneNumber(String guestPhoneNumber)
	{
		this.guestPhoneNumber=guestPhoneNumber;
	}
	public String getGuestPhoneNumber()
	{
		return guestPhoneNumber;
	}

	public void setGuestGender(String guestGender)
	{
		this.guestGender=guestGender;
	}
	public String getGuestGender()
	{
		return guestGender;
	}

	public void setGuestAdress(String guestAddress)
	{
		this.guestAddress=guestAddress;
	}
	public String getGuestAddress()
	{
		return guestAddress;
	}

	public void setGuestAgeType(String guestAgeType)
	{
		this.guestAgeType=guestAgeType;
	}
	public String guestAgeType()
	{
		return guestAgeType;
	}

	public void settTotalCost(float guestTotalCost) {
		this.guestTotalCost=guestTotalCost;

	}public float gettTotalCost() {return guestTotalCost;}

}