package com.medipaf.medipaf.ecommerce.services.servicesInter;

import com.medipaf.medipaf.ecommerce.dtos.OrderedDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.OrderNoFoundException;

import java.util.List;

public interface OrderService {

    List<OrderedDto> findAll();
    OrderedDto findById(Long id) throws OrderNoFoundException;
    OrderedDto save(OrderedDto orderedDto);
    OrderedDto update(OrderedDto orderedDto);
    void delete(Long id);


}
