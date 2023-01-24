package com.medipaf.medipaf.ecommerce.Controller;

import com.medipaf.medipaf.ecommerce.dtos.CategoryDto;
import com.medipaf.medipaf.ecommerce.dtos.ProductDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.ProductNoFoundException;
import com.medipaf.medipaf.ecommerce.services.servicesInter.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // This function helps to retrieve all existing products on the database
    @GetMapping("/all")
    @Operation(summary = "Find the entire products", description = "This method allows you to find all products and returns a list of ProductDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the products of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<List<ProductDto>> getAll(){

        List<ProductDto> productDtos=productService.findAll();

        return new ResponseEntity<>(productDtos, HttpStatus.OK);

    }

    // This function helps to retrieve a product by ID, you give the id and the function returns the product that correspond to this id
    @GetMapping("/find/{id}")
    @Operation(summary = "Find a product by id", description = "this method allows you to search for a product by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the product was found in the database",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "no product found in the database with the id provided",
                    content = @Content  )
    })
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) throws ProductNoFoundException {

        ProductDto productDto= productService.findById(id);

        return new ResponseEntity<>(productDto, HttpStatus.OK);

    }

    // This function helps to add a product to the database
    @PostMapping("/add")
    @Operation(summary = "Save a product", description = "this method allows you to save a product.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the product object created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {

        ProductDto savedProductDto= productService.save(productDto);

        return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);

    }

    // This function helps to update a product
    @PutMapping("/update")
    @Operation(summary = "Update a product", description = "this method allows you to update a product.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the product object updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {

        ProductDto updatedProductDto= productService.update(productDto);

        return new ResponseEntity<>(updatedProductDto, HttpStatus.OK);

    }

    // This function helps to delete a product from the database
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete a product", description = "this method allows you to delete a product by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the product object deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<?> delete(@PathVariable Long id) {

        productService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
