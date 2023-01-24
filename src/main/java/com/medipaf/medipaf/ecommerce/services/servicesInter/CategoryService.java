package com.medipaf.medipaf.ecommerce.services.servicesInter;

import com.medipaf.medipaf.ecommerce.dtos.CategoryDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.CategoryNotFoundException;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto findById(Long id) throws CategoryNotFoundException;

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto);

    void delete(Long id);


}
