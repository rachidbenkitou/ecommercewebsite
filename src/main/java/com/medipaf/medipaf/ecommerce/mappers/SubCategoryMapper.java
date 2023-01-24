package com.medipaf.medipaf.ecommerce.mappers;

import com.medipaf.medipaf.ecommerce.dtos.SubCategoryDto;
import com.medipaf.medipaf.ecommerce.models.SubCategory;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {

    SubCategoryDto modelToDto(SubCategory subCategory);

    List<SubCategoryDto> modelToDtos(List<SubCategory> subCategories);
    @InheritInverseConfiguration
    SubCategory dtoToModel(SubCategoryDto subCategoryDto);
}
