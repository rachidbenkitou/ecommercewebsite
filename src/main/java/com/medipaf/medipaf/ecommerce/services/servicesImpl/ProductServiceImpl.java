package com.medipaf.medipaf.ecommerce.services.servicesImpl;

import com.medipaf.medipaf.ecommerce.daos.ProductRepository;
import com.medipaf.medipaf.ecommerce.dtos.ProductDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.ProductNoFoundException;
import com.medipaf.medipaf.ecommerce.mappers.ProductMapper;
import com.medipaf.medipaf.ecommerce.models.Product;
import com.medipaf.medipaf.ecommerce.services.servicesInter.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> findAll() {

        List<Product> products= productRepository.findAll();

        List<ProductDto> productDtos= productMapper.modelsToDtos(products);

        return productDtos;

    }

    @Override
    public ProductDto findById(Long id) throws ProductNoFoundException {

        Product product= productRepository.findById(id)
                .orElseThrow(() -> new ProductNoFoundException("Product Not Found!"));

        ProductDto productDto= productMapper.modelToDto(product);

        return productDto;

    }

    @Override
    public ProductDto save(ProductDto productDto) {

        Product product= productMapper.dtoToModel(productDto);

        Product savedProduct= productRepository.save(product);

        ProductDto savedProductDto= productMapper.modelToDto(savedProduct);

        return savedProductDto;

    }

    @Override
    public ProductDto update(ProductDto productDto) {

        Product product= productMapper.dtoToModel(productDto);

        Product updatedProduct= productRepository.save(product);

        ProductDto updatedProductDto= productMapper.modelToDto(updatedProduct);

        return updatedProductDto;

    }

    @Override
    public void delete(Long id) {

        productRepository.deleteById(id);

    }
}
