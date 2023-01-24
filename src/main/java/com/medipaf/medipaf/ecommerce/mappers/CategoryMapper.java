package com.medipaf.medipaf.ecommerce.mappers;

import com.medipaf.medipaf.ecommerce.dtos.CategoryDto;
import com.medipaf.medipaf.ecommerce.models.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category dtoToModel(CategoryDto categoryDto);

    CategoryDto modelToDto(Category category);

    List<CategoryDto> modelToDtos(List<Category> categories);
}
