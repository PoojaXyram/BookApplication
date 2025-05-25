package com.enterprise.bookapplication.services;


import java.util.List;

public interface CategoryService {

    com.enterprise.bookapplication.dtos.CategoryDto saveCategory(com.enterprise.bookapplication.dtos.CategoryDto categoryDto);

    com.enterprise.bookapplication.dtos.CategoryDto getById(Integer categoryId);

    List<com.enterprise.bookapplication.dtos.CategoryDto> getAll(Integer pageNumber, Integer pageSize);

    com.enterprise.bookapplication.dtos.CategoryDto updatecategory(Integer id, com.enterprise.bookapplication.dtos.CategoryDto categoryDto);

    void deleteCategory(Integer id);

}
