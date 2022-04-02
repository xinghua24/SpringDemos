package com.xinghua24.springdocopenapi.controller;

import com.xinghua24.springdocopenapi.entity.Item;
import com.xinghua24.springdocopenapi.repository.ItemRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    // GET with path parameter
    // GET localhost:8080/items/{itemId}
    @Operation(summary = "Get item", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Item.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content) })
    @RequestMapping(value = "/{itemId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@Parameter(description = "Item Id") @PathVariable(value = "itemId") long itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        if( item.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(item.get());
        }
        return ResponseEntity.notFound().build();
    }

    // GET with path parameter
    // GET localhost:8080/items
    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemRepository.findAll());
    }

    // POST localhost:8080/items
    // @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> postItem(@RequestBody Item item) {
        Item newItem = itemRepository.save(item);
        return ResponseEntity.status(HttpStatus.OK).body(newItem);
    }



}
