package Atm;

import java.util.ArrayList;

public class Acounts {

	String pin;
	String cardNo;
	String name;
	Double balance;


	void setPin(String pin) {
		this.pin = pin;
	}

	void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	String getPin() {
		return this.pin;
	}

	String getCardNo() {
		return this.cardNo;
	}

	void setName(String name) {
		this.name = name;

	}

	String getName() {
		return this.name;
	}

	void setBalance(Double balance) {
		this.balance = balance;
	}

	Double getBalance() {
		return this.balance;
	}


}
