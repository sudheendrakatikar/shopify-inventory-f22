package com.shopify.assessment.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopify.assessment.warehouse.Warehouse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String name;

	Integer stock;

	@ManyToOne
	@JoinColumn(name = "warehouse_id")
	@JsonIgnore
	Warehouse warehouse;

	public Inventory() {
	}

	public Inventory(String _name, Integer _stock) {
		this.name = _name;
		this.stock = _stock;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}
