package com.load.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.load.entities.Loading;
import com.load.service.LoadingService;




@RestController
@RequestMapping("/loads")
public class LoadController {

    @Autowired
    private LoadingService loadService;

    @PostMapping("/load/{shipperId}")
    public ResponseEntity<String> addLoad(@RequestBody Loading load, @PathVariable Long shipperId) {
        loadService.saveLoading(load, shipperId);
        return ResponseEntity.ok("Loading details added successfully");
    }


    @GetMapping("/load/ship/{shipperId}")
 public List<Loading> getLoadsByShipperId(@PathVariable Long shipperId) {
     return loadService.getLoadingsByShipperId(shipperId);
 }

 @GetMapping("/load/{loadId}")
 public ResponseEntity<Loading> getLoadById(@PathVariable Long loadId) {
     Optional<Loading> Loading = loadService.getLoadingById(loadId);
     return Loading.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }

 @PutMapping("/load/{loadId}/{shipId}")
 public ResponseEntity<String> updateLoad(@PathVariable Long loadId,@PathVariable Long shipperId, @RequestBody Loading updatedLoad) {
     Optional<Loading> existingLoading = loadService.getLoadingById(loadId);

     if (existingLoading.isPresent()) {
         updatedLoad.setId(loadId);
         loadService.saveLoading(updatedLoad, shipperId);
         return ResponseEntity.ok("Loading details updated successfully");
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @DeleteMapping("/load/{loadId}")
 public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
     Optional<Loading> existingLoading = loadService.getLoadingById(loadId);

     if (existingLoading.isPresent()) {
         loadService.deleteLoading(loadId);
         return ResponseEntity.ok("Loading deleted successfully");
     } else {
         return ResponseEntity.notFound().build();
     }
 }
}

