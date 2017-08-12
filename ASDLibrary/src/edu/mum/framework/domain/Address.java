package edu.mum.framework.domain;

import java.io.Serializable;

public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address;
	private String city;
	private String state;
	private int zip;
    
	
	public Address() {
	
	}

	public Address(String address, String city, String state, int zip) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZip() {
		return zip;
	}

}
