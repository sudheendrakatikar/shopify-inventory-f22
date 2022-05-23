package com.shopify.assessment.warehouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.assessment.requests.WarehouseRequest;
import com.shopify.assessment.response.WarehouseResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/warehouse")
public class WarehouseController {

	@Autowired
	WarehouseService warehouseService;

	@PostMapping
	public @ResponseBody Warehouse createWarehouse(@RequestBody WarehouseRequest warehouse) {
		return warehouseService.createWarehouse(warehouse.getName(), warehouse.getStreet(), warehouse.getCity(),
				warehouse.getState());
	}

	@GetMapping
	public @ResponseBody List<WarehouseResponse> findAllWarehouse() {
		return warehouseService.findAllWarehouses();
	}

	@GetMapping("/{id}")
	public @ResponseBody WarehouseResponse findWarehouseById(@PathVariable Long id) {
		return warehouseService.findWarehouseById(id);
	}

}
