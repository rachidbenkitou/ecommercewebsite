package com.medipaf.medipaf.ecommerce.services.servicesInter;

import com.medipaf.medipaf.ecommerce.dtos.SubCategoryDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.SubCategoryNoFoundException;

import java.util.List;

public interface SubCategoryService {

    List<SubCategoryDto> findAll();

    SubCategoryDto findById(Long id) throws SubCategoryNoFoundException;

    SubCategoryDto save( SubCategoryDto subCategoryDto);

    SubCategoryDto update( SubCategoryDto subCategoryDto);

    void delete(Long id);
}
