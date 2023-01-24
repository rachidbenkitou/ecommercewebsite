package com.medipaf.medipaf.ecommerce.services.servicesImpl;

import com.medipaf.medipaf.ecommerce.daos.SubCategoryReository;
import com.medipaf.medipaf.ecommerce.dtos.SubCategoryDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.SubCategoryNoFoundException;
import com.medipaf.medipaf.ecommerce.mappers.SubCategoryMapper;
import com.medipaf.medipaf.ecommerce.models.SubCategory;
import com.medipaf.medipaf.ecommerce.services.servicesInter.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryReository subCategoryReository;

    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @Override
    public List<SubCategoryDto> findAll() {

        List<SubCategory> subCategories= subCategoryReository.findAll();

        List<SubCategoryDto> subCategoryDtos= subCategoryMapper.modelToDtos(subCategories);

        return subCategoryDtos;
    }

    @Override
    public SubCategoryDto findById(Long id) throws SubCategoryNoFoundException {

        SubCategory subCategory= subCategoryReository.findById(id)
                .orElseThrow(() -> new SubCategoryNoFoundException("Sub-Category Not Found!"));

        SubCategoryDto subCategoryDto= subCategoryMapper.modelToDto(subCategory);

        return subCategoryDto;
    }

    @Override
    public SubCategoryDto save(SubCategoryDto subCategoryDto) {

        SubCategory subCategory= subCategoryMapper.dtoToModel(subCategoryDto);

        SubCategory savedSubCategory= subCategoryReository.save(subCategory);

        SubCategoryDto savedsubCategoryDto= subCategoryMapper.modelToDto(savedSubCategory);

        return savedsubCategoryDto;

    }

    @Override
    public SubCategoryDto update(SubCategoryDto subCategoryDto) {

        SubCategory subCategory= subCategoryMapper.dtoToModel(subCategoryDto);

        SubCategory updatedSubCategory= subCategoryReository.save(subCategory);

        SubCategoryDto updatedsubCategoryDto= subCategoryMapper.modelToDto(updatedSubCategory);

        return updatedsubCategoryDto;

    }

    @Override
    public void delete(Long id) {

        subCategoryReository.deleteById(id);

    }
}
