package com.enterprise.bookapplication.controller;


import com.enterprise.bookapplication.dto.ApiResponse;
import com.enterprise.bookapplication.dto.CategoryDto;
import com.enterprise.bookapplication.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategory=this.categoryService.saveCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable Integer id){
        CategoryDto getCategory=this.categoryService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(getCategory);

    }
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAll(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                                    @RequestParam(value = "pageSize",defaultValue = "2",required = false)Integer pageSize){
        List<CategoryDto> getCategories=categoryService.getAll(pageNumber,pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(getCategories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto>updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer id){
        CategoryDto updatedCategory=categoryService.updatecategory(id,categoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id){
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Succesfully",true),HttpStatus.OK);
    }

}
