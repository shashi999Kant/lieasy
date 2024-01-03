package com.load.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.load.entities.Load;
import com.load.entities.Shipper;
import com.load.repository.LoadRepo;
import com.load.repository.ShipperRepository;

import jakarta.persistence.EntityNotFoundException;

//LoadService.java
@Service
public class LoadService {

 @Autowired
 private LoadRepo loadRepository;
 
 @Autowired
 private ShipperRepository shipperRepo;

 public Load saveLoad(Load load, Long shipperId) {
	 Shipper shipper = shipperRepo.findById(shipperId)
			 .orElseThrow(() -> new EntityNotFoundException("Shipper with id " + shipperId + " not found"));
	 
	 load.setShipper(shipper);
	 return loadRepository.save(load);
 }
 
 public List<Load> getLoadsByShipperId(Long shipperId) {
	 return loadRepository.findByShipperId(shipperId);
 }

 public Optional<Load> getLoadById(Long loadId) {
     return loadRepository.findById(loadId);
 }

 public void deleteLoad(Long loadId) {
     loadRepository.deleteById(loadId);
 }
}

