package com.shopify.assessment.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	String street;
	String city;
	String state;

	public Address() {

	}

	public Address(String _street, String _city, String _state) {
		this.street = _street;
		this.city = _city;
		this.state = _state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
