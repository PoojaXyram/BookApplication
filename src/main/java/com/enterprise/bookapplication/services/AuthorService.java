package com.enterprise.bookapplication.services;

import java.util.List;

public interface AuthorService {
    com.enterprise.bookapplication.dtos.AuthorDto createAuthor(com.enterprise.bookapplication.dtos.AuthorDto  authorDto);

   com.enterprise.bookapplication.dtos.AuthorDto  getById(Integer id);

    List<com.enterprise.bookapplication.dtos.AuthorDto > getAll(Integer pageNumber,Integer pageSize);

   com.enterprise.bookapplication.dtos.AuthorDto  updateAuthor(Integer id,com.enterprise.bookapplication.dtos.AuthorDto authorDto);

    void deleteAuthor(Integer id);
}

