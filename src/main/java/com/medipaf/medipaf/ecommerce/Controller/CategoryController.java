package com.medipaf.medipaf.ecommerce.Controller;

import com.medipaf.medipaf.ecommerce.dtos.CategoryDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.CategoryNotFoundException;
import com.medipaf.medipaf.ecommerce.services.servicesInter.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Tag(name="Category Controller")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // This function helps to retrieve all existing categories on the database
    @GetMapping("/all")
    @Operation(summary = "Find the entire categories", description = "This method allows you to find all categories and returns a list of CategoryDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the categories of objects were found",
            content = {@Content(mediaType = "application/json",
                        schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<List<CategoryDto>> getAll(){

        return  new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);

    }

    // This function helps to retrieve a category by ID, you give the id and the function returns the category that correspond to this id
    @GetMapping("/find/{id}")
    @Operation(summary = "Find a category by id", description = "this method allows you to search for a category by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the category was found in the database",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "no category found in the database with the id provided",
                        content = @Content  )
    })
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) throws CategoryNotFoundException {

        CategoryDto categoryDto=categoryService.findById(id);

        return  new ResponseEntity<>(categoryDto, HttpStatus.OK);

    }

    // This function helps to add a category to the database
    @PostMapping("/add")
    @Operation(summary = "Save a category", description = "this method allows you to save a category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the category object created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto){

        return  new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
    }

    // This function helps to update a category
    @PutMapping("/update")
    @Operation(summary = "Update a category", description = "this method allows you to update a category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the category object updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto){

        return  new ResponseEntity<>(categoryService.update(categoryDto), HttpStatus.OK);

    }

    // This function helps to delete a category from the database
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete a category", description = "this method allows you to delete a category by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the category object deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<?> delete(@PathVariable Long id){

        categoryService.delete(id);

        return  new ResponseEntity<>(HttpStatus.OK);

    }

}
