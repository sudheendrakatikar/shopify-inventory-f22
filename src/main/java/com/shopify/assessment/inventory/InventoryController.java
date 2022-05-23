package com.shopify.assessment.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.assessment.response.InventoryResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/inventory")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	@PostMapping
	public @ResponseBody Inventory createItem(@RequestBody Inventory item) {
		return inventoryService.createInventory(item.getName(), item.getStock());
	}

	@GetMapping
	public @ResponseBody List<InventoryResponse> getInventory() {
		return inventoryService.getInventory();
	}

	@GetMapping("/{id}")
	public @ResponseBody InventoryResponse findInventoryById(@PathVariable Long id) {
		return inventoryService.findInventoryById(id);
	}

	@GetMapping("/search")
	public @ResponseBody List<Inventory> findInventoryByName(@RequestParam String itemName) {
		return inventoryService.findInventoryByName(itemName);
	}

	@PutMapping("/{id}")
	public @ResponseBody Inventory updateItem(@PathVariable Long id, @RequestBody Inventory item) {
		return inventoryService.updateInventory(id, item.getName(), item.getStock());
	}

	@DeleteMapping("/{id}")
	public @ResponseBody void deleteItem(@PathVariable Long id) {
		inventoryService.deleteInventory(id);
	}

	@PostMapping("/{inventory}/assign/{warehouse}")
	public @ResponseBody Inventory assignWarehouse(@PathVariable("inventory") Long inventoryid,
			@PathVariable("warehouse") Long warehouseId) {
		return inventoryService.assignWarehouse(inventoryid, warehouseId);
	}

}
