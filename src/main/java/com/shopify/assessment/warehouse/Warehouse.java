package com.shopify.assessment.warehouse;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopify.assessment.inventory.Inventory;
import com.shopify.assessment.models.Address;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String name;

	Address address;

	@OneToMany(mappedBy = "warehouse")
	@JsonIgnore
	List<Inventory> inventory;

	public Warehouse() {
	}

	public Warehouse(String _name, Address _address) {
		this.name = _name;
		this.address = _address;
		this.inventory = new ArrayList<>();
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

	public List<Inventory> getInventory() {
		return inventory;
	}

	public void addInventory(Inventory _inventory) {
		this.inventory.add(_inventory);
	}

}
