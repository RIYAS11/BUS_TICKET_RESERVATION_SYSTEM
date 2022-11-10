package com.travel.model;

public class Customer {

		
	private String cnmae;
	
	private String Address;
	
	private String Cmobile;
	
	private String password;

	@Override
	public String toString() {
		return "Customer [cnmae=" + cnmae + ", Address=" + Address + ", Cmobile=" + Cmobile + ", password=" + password
				+ "]";
	}

	public String getCnmae() {
		return cnmae;
	}

	public void setCnmae(String cnmae) {
		this.cnmae = cnmae;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCmobile() {
		return Cmobile;
	}

	public void setCmobile(String cmobile) {
		Cmobile = cmobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(String cnmae, String address, String cmobile, String password) {
		super();
		this.cnmae = cnmae;
		Address = address;
		Cmobile = cmobile;
		this.password = password;
	}
	
	
	public Customer() {
		
	}
	
	
	
}
