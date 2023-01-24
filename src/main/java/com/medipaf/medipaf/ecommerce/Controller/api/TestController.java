/*
package com.medipaf.medipaf.ecommerce.Controller;

import com.medipaf.medipaf.ecommerce.Controller.api.CategoryApi;
import com.medipaf.medipaf.ecommerce.dtos.CategoryDto;
import com.medipaf.medipaf.ecommerce.services.servicesInter.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController implements CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseEntity<List<CategoryDto>> getAll() {
        return  new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
}
 */
