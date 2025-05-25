package com.enterprise.bookapplication.dtos;


import com.enterprise.bookapplication.entity.Author;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class BookDto {

    private Integer id;

    @Pattern(regexp = "^[0-9]+$")
    @Size(max = 25)
    private String isbn;

    @NotEmpty
    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private com.enterprise.bookapplication.dtos.AuthorDto authorDto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private com.enterprise.bookapplication.dtos.CategoryDto categoryDto;


    public com.enterprise.bookapplication.dtos.AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(com.enterprise.bookapplication.dtos.AuthorDto authorDto) {
        this.authorDto = authorDto;
    }

    public com.enterprise.bookapplication.dtos.CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(com.enterprise.bookapplication.dtos.CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
