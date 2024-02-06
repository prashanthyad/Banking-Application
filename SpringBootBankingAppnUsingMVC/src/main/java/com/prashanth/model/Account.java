package com.prashanth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
     @Id
     private int acc_no;
     private String name;
     private String password;
     private double amount;
     private String address;
     private int mobileno;
	public Account() {
		super();
	}
	public Account(int acc_no, String name, String password, double amount, String address, int mobileno) {
		super();
		this.acc_no = acc_no;
		this.name = name;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.mobileno = mobileno;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	@Override
	public String toString() {
		return "Account [acc_no=" + acc_no + ", name=" + name + ", password=" + password + ", amount=" + amount
				+ ", address=" + address + ", mobileno=" + mobileno + "]";
	}
     
}
