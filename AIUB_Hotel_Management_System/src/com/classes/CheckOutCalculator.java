package com.classes;

import java.lang.*;
import java.lang.String;

public class CheckOutCalculator extends PackageAndDiscount {
	protected float FinalCost =0;
	protected float VAT;
	protected float cashPaid;
	protected float returnChange;

	String[] paymentType= new String[4];
	public CheckOutCalculator() {
		paymentType[0] = "Cash";
		paymentType[1] = "Mobile Banking";
		paymentType[2] = "Visa Card";
		paymentType[3] = "Debit Card";
	}
	public void CheckOutCalculator(int index){ //index 0 means hotel room and service || index 1 means Package

		switch (index){
			case 0:
				FinalCost = 0;
				FinalCost = totalRoomCost+ totalServiceCost ;
			break;

			case 1:
				FinalCost = 0;
				FinalCost = TotalPackageCost;
				break;
		}
	} public float getTotalCost(){return FinalCost;}

	public void setVAT() {

		VAT = (float) (FinalCost * 0.15);

	} public float getVAT(){ return VAT; }

	public float returnChangeCalculator(float CashPaid) {

		if (CashPaid >= FinalCost) {
			returnChange = CashPaid - FinalCost;
			return returnChange;

		} else {
			System.out.println("Error. Sorry your paid amount is not sufficient to complete this transction.");
			return 0;
		}
	}


}