
just need to add the following dependency
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.6</version>
</dependency>
```

After adding the dependency, you can already visit swagger at http://localhost:8080/swagger-ui.html


# Sample Swagger V3 annotation usage:
```java
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
```

Reference: 
* [SpringDoc Documentation - https://springdoc.org/#Introduction](https://springdoc.org/#Introduction)
* [Migrate From Springfox Documentation](https://springdoc.org/#migrating-from-springfox)