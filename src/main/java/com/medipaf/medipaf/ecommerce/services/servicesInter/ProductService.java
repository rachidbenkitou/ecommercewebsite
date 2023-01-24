package com.medipaf.medipaf.ecommerce.services.servicesInter;

import com.medipaf.medipaf.ecommerce.dtos.ProductDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.ProductNoFoundException;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findById(Long id) throws ProductNoFoundException;

    ProductDto save(ProductDto productDto);

    ProductDto update(ProductDto productDto);

    void delete(Long id);


}
