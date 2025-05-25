package com.enterprise.bookapplication.controller;


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
    public ResponseEntity<com.enterprise.bookapplication.dtos.CategoryDto> createCategory(@Valid @RequestBody com.enterprise.bookapplication.dtos.CategoryDto categoryDto){
        com.enterprise.bookapplication.dtos.CategoryDto createCategory=this.categoryService.saveCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.CategoryDto> getById(@PathVariable Integer id){
        com.enterprise.bookapplication.dtos.CategoryDto getCategory=this.categoryService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(getCategory);

    }
    @GetMapping("/")
    public ResponseEntity<List<com.enterprise.bookapplication.dtos.CategoryDto>> getAll(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                                                                        @RequestParam(value = "pageSize",defaultValue = "2",required = false)Integer pageSize){
        List<com.enterprise.bookapplication.dtos.CategoryDto> getCategories=categoryService.getAll(pageNumber,pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(getCategories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.CategoryDto>updateCategory(@RequestBody com.enterprise.bookapplication.dtos.CategoryDto categoryDto, @PathVariable Integer id){
        com.enterprise.bookapplication.dtos.CategoryDto updatedCategory=categoryService.updatecategory(id,categoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.ApiResponse> deleteCategory(@PathVariable Integer id){
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<com.enterprise.bookapplication.dtos.ApiResponse>(new com.enterprise.bookapplication.dtos.ApiResponse("Deleted Succesfully",true),HttpStatus.OK);
    }

}
