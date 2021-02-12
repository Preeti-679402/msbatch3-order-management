package com.sl.ms.ordermanagement.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api/v1")
public class InventoryResource {

    private static Logger LOGGER = LogManager.getLogger(InventoryResource.class);

    @Autowired
    private InventoryRepository inventoryRepository;


    @GetMapping("/orders")
    public List<Inventory> retrieveAllInventories() {

       LOGGER.info("Inventory retrieveAllInventories");
        return inventoryRepository.findAll();
    }


    @GetMapping("/orders/{id}")
    public Inventory retrieveInventory(@PathVariable long id) {
        LOGGER.info("Inventory -- retrieveInventory");
        Optional<Inventory> inventory = inventoryRepository.findById(id);

        LOGGER.info("Inventory -- retrieveInventory to get by ID"+ inventory);

        if (!inventory.isPresent()) {
            LOGGER.error("Inventory is not present " + id);
            throw new InventortNotFoundException("id-" + id);
        }

        return inventory.get();
    }

    @DeleteMapping("/orders/{id}")
    public void deleteInventory(@PathVariable long id) {
       LOGGER.info("Inventory -- retrieveInventory to delete by ID"+ id);
        inventoryRepository.deleteById(id);
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createInventory(@RequestBody Inventory inventory) {
       LOGGER.info("Inventory -- createInventory ");
        Inventory savedInventory = inventoryRepository.save(inventory);

        LOGGER.info("Inventory -- savedInventory to save the data"+ savedInventory);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedInventory.getId()).toUri();

        LOGGER.info("Inventory -- retrieve location"+ location);

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Object> updateInventory(@RequestBody Inventory inventory, @PathVariable long id) {

        LOGGER.info("Inventory -- updateInventory");
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);

        LOGGER.info("Inventory -- inventoryOptional in update"+inventoryOptional);

        if (!inventoryOptional.isPresent()) {
            LOGGER.error("Inventory is not present ");
            return ResponseEntity.notFound().build();
        }

        inventory.setId(id);

        inventoryRepository.save(inventory);

        LOGGER.info("Inventory saved");
        return ResponseEntity.noContent().build();
    }


}
