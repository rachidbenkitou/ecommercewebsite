package com.medipaf.medipaf.ecommerce.services.servicesImpl;

import com.medipaf.medipaf.ecommerce.daos.OrderRepository;
import com.medipaf.medipaf.ecommerce.dtos.OrderedDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.OrderNoFoundException;
import com.medipaf.medipaf.ecommerce.mappers.OrderedMapper;
import com.medipaf.medipaf.ecommerce.models.Ordered;
import com.medipaf.medipaf.ecommerce.services.servicesInter.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderedMapper orderedMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<OrderedDto> findAll() {

        List<Ordered> ordereds= orderRepository.findAll();

        List<OrderedDto> orderedDtos= orderedMapper.modelToDtos(ordereds);

        return orderedDtos;

    }

    @Override
    public OrderedDto findById(Long id) throws OrderNoFoundException {

        Ordered ordered= orderRepository.findById(id)
                .orElseThrow(() -> new OrderNoFoundException("Order Not Found!"));

        OrderedDto orderedDto= orderedMapper.modelToDto(ordered);

        return orderedDto;

    }

    @Override
    public OrderedDto save(OrderedDto orderedDto) {

        Ordered ordered= orderedMapper.dtoToModel(orderedDto);

        Ordered savedOrder= orderRepository.save(ordered);

        OrderedDto savedOrderDto= orderedMapper.modelToDto(savedOrder);

        return savedOrderDto;

    }

    @Override
    public OrderedDto update(OrderedDto orderedDto) {

        Ordered ordered= orderedMapper.dtoToModel(orderedDto);

        Ordered updatedOrder= orderRepository.save(ordered);

        OrderedDto updatedOrderDto= orderedMapper.modelToDto(updatedOrder);

        return updatedOrderDto;

    }

    @Override
    public void delete(Long id) {

        orderRepository.deleteById(id);

    }
}
