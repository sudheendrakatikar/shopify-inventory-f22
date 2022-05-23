package com.shopify.assessment.response;

import java.util.List;

import com.shopify.assessment.models.Address;

public class WarehouseResponse {
	Long id;
	String name;
	Address address;
	List<InventoryResponse> inventory;
	
	public WarehouseResponse() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<InventoryResponse> getInventory() {
		return inventory;
	}

	public void setInventory(List<InventoryResponse> inventory) {
		this.inventory = inventory;
	}
	
}
