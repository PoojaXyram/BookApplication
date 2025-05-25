package com.enterprise.bookapplication.services;

import com.enterprise.bookapplication.dto.BookDto;
import com.enterprise.bookapplication.dto.BookResponse;
import java.util.List;

public interface BookService {

  BookDto createBook(BookDto bookDto);

  BookDto getById(Integer id);

  BookResponse getAll(Integer pageNumber, Integer pageSize, String sortBy, String sortDirec);

  BookDto updateBook(Integer id, BookDto bookDto);

  void deletebook(Integer id);

  List<BookDto> findByAuthor(Integer id);

  List<BookDto> findByCategory(Integer id);
}
