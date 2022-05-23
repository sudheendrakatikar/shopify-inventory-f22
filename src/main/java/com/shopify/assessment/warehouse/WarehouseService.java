package com.shopify.assessment.warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.assessment.models.Address;
import com.shopify.assessment.response.InventoryResponse;
import com.shopify.assessment.response.WarehouseResponse;

@Service
public class WarehouseService {

	@Autowired
	WarehouseRepository warehouseRepository;

	public Warehouse createWarehouse(String name, String street, String city, String state) {
		Address address = new Address(street, city, state);
		Warehouse warehouse = new Warehouse(name, address);
		return warehouseRepository.save(warehouse);
	}

	public List<WarehouseResponse> findAllWarehouses() {
		List<Warehouse> warehouses = warehouseRepository.findAll();
		List<WarehouseResponse> warehouseResponse = new ArrayList<>();
		warehouses.forEach((warehouse) -> {
			warehouseResponse.add(createWarehouseResponse(warehouse));
		});
		return warehouseResponse;
	}

	public WarehouseResponse findWarehouseById(Long id) {
		Optional<Warehouse> warehouseDao = warehouseRepository.findById(id);
		if (warehouseDao.isEmpty())
			return null;
		Warehouse warehouse = warehouseDao.get();
		return createWarehouseResponse(warehouse);

	}

	public WarehouseResponse createWarehouseResponse(Warehouse warehouse) {
		WarehouseResponse response = new WarehouseResponse();
		response.setId(warehouse.getId());
		response.setName(warehouse.getName());
		response.setAddress(warehouse.getAddress());
		List<InventoryResponse> inventory = new ArrayList<>();
		warehouse.getInventory().forEach((item) -> {
			InventoryResponse inventoryResponse = new InventoryResponse();
			inventoryResponse.setId(item.getId());
			inventoryResponse.setName(item.getName());
			inventoryResponse.setStock(item.getStock());
			inventory.add(inventoryResponse);
		});
		response.setInventory(inventory);
		return response;
	}

}
