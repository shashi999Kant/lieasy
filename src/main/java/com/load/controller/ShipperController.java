package com.load.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.load.entities.Shipper;
import com.load.service.ShipperService;

@RestController
@RequestMapping("/shipper")
public class ShipperController {
	 @Autowired
	    private ShipperService service;

	    @PostMapping("/ship")
	    public ResponseEntity<String> addShip(@RequestBody Shipper ship) {
	        this.service.addShipper(ship);
	        return ResponseEntity.ok("Ship details added successfully");
	    }
	    
	    @DeleteMapping("/{shipId}")
	    public ResponseEntity<String>deleteShip(@PathVariable long shipId)
	    {
	    	this.service.deleteShipper(shipId);
	        return ResponseEntity.ok("Ship details deleted successfully");
	    	
	    }
}
