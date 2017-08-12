package edu.mum.framework.domain;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class AUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private LocalDate dob;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Address address;
	private UserStatus userStatus;
	private ACredential credentialA;


	public AUser(String id, LocalDate dob, String firstName, String lastName, String phoneNumber, Address address,
			UserStatus userStatus, ACredential credentialA) {

		this.id = id;
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userStatus = userStatus;
		this.credentialA = credentialA;
	}
	
	public AUser(String id, LocalDate dob, String firstName, String lastName, String phoneNumber) {

		this.id = id;
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public boolean equals(Object object) {

		if (object == null)
			return false;
		else if (object.getClass() != this.getClass())
			return false;
		AUser person = (AUser) object;
		return person.getId() == (this.id);
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", dob=" + dob + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", userStatus=" + userStatus
				+ ", credential=" + credentialA + "]";
	}

	public ACredential getCredentialA() {
		return credentialA;
	}

	public void setCredentialA(ACredential credentialA) {
		this.credentialA = credentialA;
	}

}
