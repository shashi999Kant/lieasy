package com.load.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.load.entities.Shipper;
import com.load.repository.ShipperRepository;

@Service
public class ShipperService {
	
	@Autowired
	private ShipperRepository shipperRepo;
	
	public Shipper addShipper(Shipper shipper) {
		return this.shipperRepo.save(shipper);
	}
	
	public void deleteShipper(Long shipperId)
	{
		Shipper shipper = this.shipperRepo.findById(shipperId).get();
		this.shipperRepo.delete(shipper);
	}

}
