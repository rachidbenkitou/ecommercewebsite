package com.medipaf.medipaf.ecommerce.Controller;

import com.medipaf.medipaf.ecommerce.dtos.CategoryDto;
import com.medipaf.medipaf.ecommerce.dtos.ClientDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.ClientNoFoundException;
import com.medipaf.medipaf.ecommerce.services.servicesInter.ClientService;
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
@RequestMapping("/clients")
public class ClientController {


    @Autowired
    private ClientService clientService;

    // This function helps to retrieve all existing clients on the database
    @GetMapping("/all")
    @Operation(summary = "Find the entire clients", description = "This method allows you to find all clients and returns a list of ClientDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the clients of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<List<ClientDto>> getAll(){

        return  new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    // This function helps to retrieve a client by ID, you give the id and the function returns the client that correspond to this id
    @GetMapping("/find/{id}")
    @Operation(summary = "Find a client by id", description = "this method allows you to search for a client by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the client was found in the database",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "no client found in the database with the id provided",
                    content = @Content  )
    })
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) throws ClientNoFoundException {

        ClientDto clientDto= clientService.findById(id);

        return  new ResponseEntity<>(clientDto, HttpStatus.OK);

    }

    // This function helps to add a client to the database
    @PostMapping("/add")
    @Operation(summary = "Save a client", description = "this method allows you to save a client.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the client object created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto){

        return  new ResponseEntity<>(clientService.save(clientDto), HttpStatus.CREATED);
    }

    // This function helps to update a client
    @PutMapping("/update")
    @Operation(summary = "Update a client", description = "this method allows you to update a client.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the client object updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto clientDto){

        return  new ResponseEntity<>(clientService.update(clientDto), HttpStatus.OK);
    }

    // This function helps to delete a client from the database
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete a client", description = "this method allows you to delete a client by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the client object deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    public ResponseEntity<?> delete(@PathVariable Long id){

        clientService.delete(id);

        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
