package com.load.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.load.entities.Loading;
import com.load.entities.Shipper;
import com.load.repository.LoadRepo;
import com.load.repository.ShipperRepository;

import jakarta.persistence.EntityNotFoundException;

//LoadingService.java
@Service
public class LoadingService {

 @Autowired
 private LoadRepo loadRepo;
 
 @Autowired
 private ShipperRepository shipperRepo;

 public Loading saveLoading(Loading Loading, Long shipperId) {
	 Shipper shipper = shipperRepo.findById(shipperId)
			 .orElseThrow(() -> new EntityNotFoundException("Shipper with id " + shipperId + " not found"));
	 
	 Loading.setShipper(shipper);
	 return loadRepo.save(Loading);
 }
 
 public List<Loading> getLoadingsByShipperId(Long shipperId) {
	 return loadRepo.findByShipperId(shipperId);
 }

 public Optional<Loading> getLoadingById(Long LoadingId) {
     return loadRepo.findById(LoadingId);
 }

 public void deleteLoading(Long LoadingId) {
	 loadRepo.deleteById(LoadingId);
 }
}

