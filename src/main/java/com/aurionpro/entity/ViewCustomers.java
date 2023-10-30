package com.aurionpro.entity;

public class ViewCustomers {
	
	private String firstName;
	private String lastName;
	private Long accNo;
	private int balance;
	
	public ViewCustomers(String firstName, String lastName, Long accountnumber, int balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accNo = accountnumber;
		this.balance = balance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = (long) accNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "ViewCustomers [firstName=" + firstName + ", lastName=" + lastName + ", accNo=" + accNo + ", balance="
				+ balance + "]";
	}


}
