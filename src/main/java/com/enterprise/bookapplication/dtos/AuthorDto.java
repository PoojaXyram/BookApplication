package com.enterprise.bookapplication.dtos;


import com.enterprise.bookapplication.entity.Book;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AuthorDto {

    private Integer authorId;
    @NotNull
    @NotEmpty
    @Max(value = 25, message = "Author Name should not exceed 25 characters")
    private String authorName;
    @NotEmpty
    private String nationality;

//    private List<Book> bookList = new ArrayList<>();
//
//    public List<Book> getBookList() {
//        return bookList;
//    }
//
//    public void setBookList(List<Book> bookList) {
//        this.bookList = bookList;
//    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
