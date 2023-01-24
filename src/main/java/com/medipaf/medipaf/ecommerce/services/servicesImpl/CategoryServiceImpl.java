package com.medipaf.medipaf.ecommerce.services.servicesImpl;

import com.medipaf.medipaf.ecommerce.daos.CategoryRepository;
import com.medipaf.medipaf.ecommerce.dtos.CategoryDto;
import com.medipaf.medipaf.ecommerce.exceptions.NotFoundExceptions.CategoryNotFoundException;
import com.medipaf.medipaf.ecommerce.mappers.CategoryMapper;
import com.medipaf.medipaf.ecommerce.models.Category;
import com.medipaf.medipaf.ecommerce.services.servicesInter.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAll() {

        return categoryMapper.modelToDtos(categoryRepository.findAll());
    }

    @Override
    public CategoryDto findById(Long id) throws CategoryNotFoundException {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category Not Found"));

        CategoryDto categoryDto= categoryMapper.modelToDto(category);

        return categoryDto;

    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {


        Category category=categoryMapper.dtoToModel(categoryDto);

        return categoryMapper.modelToDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {

        Category category=categoryMapper.dtoToModel(categoryDto);

        return categoryMapper.modelToDto(categoryRepository.save(category));
    }

    @Override
    public void delete(Long id) {

        categoryRepository.deleteById(id);

    }
}
