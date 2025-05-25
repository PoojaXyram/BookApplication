package com.enterprise.bookapplication.services;


import com.enterprise.bookapplication.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto saveCategory(CategoryDto categoryDto);

    CategoryDto getById(Integer categoryId);

    List<CategoryDto> getAll(Integer pageNumber, Integer pageSize);

    CategoryDto updatecategory(Integer id, CategoryDto categoryDto);

    void deleteCategory(Integer id);

}
