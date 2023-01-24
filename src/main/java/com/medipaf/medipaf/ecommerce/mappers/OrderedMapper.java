package com.medipaf.medipaf.ecommerce.mappers;

import com.medipaf.medipaf.ecommerce.dtos.OrderedDto;
import com.medipaf.medipaf.ecommerce.models.Ordered;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderedMapper {
    OrderedDto modelToDto(Ordered ordered);
    List<OrderedDto> modelToDtos( List<Ordered> ordereds);
    Ordered dtoToModel(OrderedDto orderedDto);

}
