package com.enterprise.bookapplication.serviceimpl;




import com.enterprise.bookapplication.dao.CategoryDao;
import com.enterprise.bookapplication.dto.CategoryDto;
import com.enterprise.bookapplication.entity.Category;
import com.enterprise.bookapplication.exceptions.ResourceNotFound;
import com.enterprise.bookapplication.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ModelMapper modelMapper;

        @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category categories=this.modelMapper.map(categoryDto, Category.class);
        Category savecategories=categoryDao.save(categories);
        return this.modelMapper.map(savecategories, CategoryDto.class);
    }

    @Override
    public CategoryDto getById(Integer categoryId) {
        Category getcategoryById=this.categoryDao.findById(categoryId).orElseThrow(()->new ResourceNotFound("Categories",categoryId));
        return this.modelMapper.map(getcategoryById, CategoryDto.class);

    }

    @Override
    public List<CategoryDto> getAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Category> page = this.categoryDao.findAll(pageable);
        List<Category> getAll = page.getContent();
        return getAll.stream()
                .map(category -> this.modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updatecategory(Integer id, CategoryDto categoryDto) {
            Category categories=this.categoryDao.findById(id).orElseThrow(()->new ResourceNotFound("Categories",id));
            categories.setTitle(categoryDto.getTitle());
            categories.setDescription(categoryDto.getDescription());
            categories.setCreatedAt(categoryDto.getCreatedAt());
            Category updatedCategory=this.categoryDao.save(categories);
            return this.modelMapper.map(updatedCategory, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category categories=this.categoryDao.findById(id).orElseThrow(()->new ResourceNotFound("Categories",id));
         this.categoryDao.delete(categories);
    }


}
