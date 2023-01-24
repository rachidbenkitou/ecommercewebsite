package com.medipaf.medipaf.ecommerce.mappers;

import com.medipaf.medipaf.ecommerce.dtos.ProductDto;
import com.medipaf.medipaf.ecommerce.models.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;


import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto modelToDto(Product product);

    List<ProductDto> modelsToDtos(List<Product> products);
    Product dtoToModel(ProductDto productDto);
}
