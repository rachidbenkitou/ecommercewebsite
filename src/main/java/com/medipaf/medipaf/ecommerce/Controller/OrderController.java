package com.medipaf.medipaf.ecommerce.Controller;

import com.medipaf.medipaf.ecommerce.dtos.CategoryDto;
import com.medipaf.medipaf.ecommerce.dtos.OrderedDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.OrderNoFoundException;
import com.medipaf.medipaf.ecommerce.models.ProductOrder;
import com.medipaf.medipaf.ecommerce.services.servicesInter.OrderService;
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
import java.util.Set;



@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // This function helps to retrieve all existing orders on the database
    @GetMapping("/all")
    @Operation(summary = "Find the entire orders", description = "This method allows you to find all orders and returns a list of OrderedDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the orders of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<List<OrderedDto>> getAll(){

        List<OrderedDto> orderedDtos=orderService.findAll();

        return new ResponseEntity<>(orderedDtos, HttpStatus.OK);

    }

    // This function helps to retrieve a order by ID, you give the id and the function returns the order that correspond to this id
    @GetMapping("/find/{id}")
    @Operation(summary = "Find a order by id", description = "this method allows you to search for a order by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the order was found in the database",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "no order found in the database with the id provided",
                    content = @Content  )
    })
    public ResponseEntity<OrderedDto> getById(@PathVariable Long id) throws OrderNoFoundException {

        OrderedDto orderedDto= orderService.findById(id);

        Set<ProductOrder> productOrderDtos=orderedDto.getProductOrders();
        for (ProductOrder p: productOrderDtos) System.out.println(p.getOrdered().getSerie()+"\n"+p.getDate()+"\n"+p.getQuantity()+"\n"+p.getProduct().getName());


        return new ResponseEntity<>(orderedDto, HttpStatus.OK);

    }

    // This function helps to add a order to the database
    @PostMapping("/add")
    @Operation(summary = "Save a order", description = "this method allows you to save a order.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the order object created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<OrderedDto> save(@RequestBody OrderedDto orderedDto) {

        OrderedDto savedOrderDto= orderService.save(orderedDto);

        return new ResponseEntity<>(savedOrderDto, HttpStatus.CREATED);

    }

    // This function helps to update a order
    @PutMapping("/update")
    @Operation(summary = "Update a order", description = "this method allows you to update a order.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the order object updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<OrderedDto> update(@RequestBody OrderedDto orderedDto) {

        OrderedDto updatedOrderDto= orderService.update(orderedDto);

        return new ResponseEntity<>(updatedOrderDto, HttpStatus.OK);

    }

    // This function helps to delete a order from the database
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete a order", description = "this method allows you to delete a order by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the order object deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<?> delete(@PathVariable Long id) {

        orderService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
