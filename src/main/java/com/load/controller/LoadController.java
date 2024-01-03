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

import com.load.entities.Load;
import com.load.service.LoadService;

//LoadController.java
@RestController
@RequestMapping("/loads")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping("/load")
    public ResponseEntity<String> addLoad(@RequestBody Load load, @RequestParam Long shipperId) {
        loadService.saveLoad(load, shipperId);
        return ResponseEntity.ok("Load details added successfully");
    }


 @GetMapping
 public List<Load> getLoadsByShipperId(@RequestParam Long shipperId) {
     return loadService.getLoadsByShipperId(shipperId);
 }

 @GetMapping("/load/{loadId}")
 public ResponseEntity<Load> getLoadById(@PathVariable Long loadId) {
     Optional<Load> load = loadService.getLoadById(loadId);
     return load.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }

 @PutMapping("/load/{loadId}")
 public ResponseEntity<String> updateLoad(@PathVariable Long loadId,@PathVariable Long shipperId, @RequestBody Load updatedLoad) {
     Optional<Load> existingLoad = loadService.getLoadById(loadId);

     if (existingLoad.isPresent()) {
         updatedLoad.setId(loadId);
         loadService.saveLoad(updatedLoad,shipperId);
         return ResponseEntity.ok("Load details updated successfully");
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @DeleteMapping("/load/{loadId}")
 public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
     Optional<Load> existingLoad = loadService.getLoadById(loadId);

     if (existingLoad.isPresent()) {
         loadService.deleteLoad(loadId);
         return ResponseEntity.ok("Load deleted successfully");
     } else {
         return ResponseEntity.notFound().build();
     }
 }
}

