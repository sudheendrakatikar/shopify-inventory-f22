package com.shopify.assessment.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.assessment.response.InventoryResponse;
import com.shopify.assessment.warehouse.Warehouse;
import com.shopify.assessment.warehouse.WarehouseRepository;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Autowired
	WarehouseRepository warehouseRepository;

	public Inventory createInventory(String InventoryName, Integer stock) {
		Inventory Inventory = new Inventory(InventoryName, stock);
		return inventoryRepository.save(Inventory);
	}

	public List<InventoryResponse> getInventory() {
		List<Inventory> inventory = inventoryRepository.findAll();
		List<InventoryResponse> inventoryResponse = new ArrayList<>();
		inventory.forEach((item) -> {
			inventoryResponse.add(createInventoryResponse(item));
		});
		return inventoryResponse;
	}

	public InventoryResponse findInventoryById(Long id) {
		Optional<Inventory> inventoryDao = inventoryRepository.findById(id);
		if (inventoryDao.isEmpty())
			return null;
		Inventory inventory = inventoryDao.get();
		return createInventoryResponse(inventory);
	}

	public List<Inventory> findInventoryByName(String name) {
		return inventoryRepository.findByName(name);
	}

	public Inventory updateInventory(Long id, String name, Integer stock) {
		Optional<Inventory> Inventory = inventoryRepository.findById(id);
		// Check for Inventory exists
		Inventory updatedInventory = Inventory.get();
		updatedInventory.setName(name);
		updatedInventory.setStock(stock);
		return inventoryRepository.save(updatedInventory);

	}

	public void deleteInventory(Long id) {
		inventoryRepository.deleteById(id);
	}

	public Inventory assignWarehouse(Long inventoryId, Long warehouseId) {
		Optional<Inventory> inventory = inventoryRepository.findById(inventoryId);
		// Check for inventory exists
		Optional<Warehouse> warehouse = warehouseRepository.findById(warehouseId);
		// Check for warehouse exists
		Inventory assignInventory = inventory.get();
		Warehouse assignWarehouse = warehouse.get();
		assignInventory.setWarehouse(assignWarehouse);
		assignWarehouse.addInventory(assignInventory);
		warehouseRepository.save(assignWarehouse);
		return inventoryRepository.save(assignInventory);
	}

	public InventoryResponse createInventoryResponse(Inventory inventory) {
		InventoryResponse response = new InventoryResponse();
		response.setId(inventory.getId());
		response.setName(inventory.getName());
		response.setStock(inventory.getStock());
		Warehouse warehouse = inventory.getWarehouse();
		if (warehouse != null) {
			response.setWarehouseId(warehouse.getId());
			response.setWarehouseName(warehouse.getName());
		}
		return response;
	}

}
