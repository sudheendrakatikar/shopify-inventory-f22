package com.shopify.assessment.response;

public class InventoryResponse {
	Long id;
	String name;
	Integer stock;
	Long warehouseId;
	String warehouseName;

	public InventoryResponse() {

	}

	public InventoryResponse(Long id, String name, Integer stock, Long warehouseId, String warehouseName) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.warehouseId = warehouseId;
		this.warehouseName = warehouseName;
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

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

}
