package com.enterprise.bookapplication.services;


import java.util.List;


public interface BookService {

    com.enterprise.bookapplication.dtos.BookDto createBook(com.enterprise.bookapplication.dtos.BookDto bookDto);

    com.enterprise.bookapplication.dtos.BookDto getById(Integer id);

   com.enterprise.bookapplication.dtos.BookResponse getAll(Integer pageNumber, Integer pageSize, String sortBy, String sortDirec);

    com.enterprise.bookapplication.dtos.BookDto updateBook(Integer id, com.enterprise.bookapplication.dtos.BookDto bookDto);

    void deletebook(Integer id);

    List<com.enterprise.bookapplication.dtos.BookDto> findByAuthor(Integer id);

    List<com.enterprise.bookapplication.dtos.BookDto> findByCategory(Integer id);

}
