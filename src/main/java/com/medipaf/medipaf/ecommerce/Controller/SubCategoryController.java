package com.medipaf.medipaf.ecommerce.Controller;

import com.medipaf.medipaf.ecommerce.dtos.CategoryDto;
import com.medipaf.medipaf.ecommerce.dtos.SubCategoryDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.SubCategoryNoFoundException;
import com.medipaf.medipaf.ecommerce.services.servicesInter.SubCategoryService;
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
@RequestMapping("/subcategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    // This function helps to retrieve all existing subcategories on the database
    @GetMapping("/all")
    @Operation(summary = "Find the entire sub-categories", description = "This method allows you to find all sub-categories and returns a list of SubCategoryDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the sub-categories of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<List<SubCategoryDto>> getAll(){

        List<SubCategoryDto> subCategoryDtos=subCategoryService.findAll();

        return new ResponseEntity<>(subCategoryDtos, HttpStatus.OK);

    }

    // This function helps to retrieve a subcategory by ID, you give the id and the function returns the subcategory that correspond to this id
    @GetMapping("/find/{id}")
    @Operation(summary = "Find a sub-category by id", description = "this method allows you to search for a sub-category by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the sub-category was found in the database",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "no sub-category found in the database with the id provided",
                    content = @Content  )
    })
    public ResponseEntity<SubCategoryDto> getById(@PathVariable Long id) throws SubCategoryNoFoundException {

        SubCategoryDto subCategoryDto= subCategoryService.findById(id);

        return new ResponseEntity<>(subCategoryDto, HttpStatus.OK);

    }

    // This function helps to add a subcategory to the database
    @PostMapping("/add")
    @Operation(summary = "Save a sub-category", description = "this method allows you to save a sub-category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the sub-category object created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<SubCategoryDto> save(@RequestBody SubCategoryDto subCategoryDto) {

        SubCategoryDto savedSubCategoryDto= subCategoryService.save(subCategoryDto);

        return new ResponseEntity<>(savedSubCategoryDto, HttpStatus.CREATED);

    }

    // This function helps to update a subcategory
    @PutMapping("/update")
    @Operation(summary = "Update a sub-category", description = "this method allows you to update a sub-category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the sub-category object updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<SubCategoryDto> update(@RequestBody SubCategoryDto subCategoryDto) {

        SubCategoryDto updatedSubCategoryDto= subCategoryService.update(subCategoryDto);

        return new ResponseEntity<>(updatedSubCategoryDto, HttpStatus.OK);

    }

    // This function helps to delete a subcategory from the database
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete a sub-category", description = "this method allows you to delete a sub-categoryby id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the sub-category object deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<?> delete(@PathVariable Long id) {

        subCategoryService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
