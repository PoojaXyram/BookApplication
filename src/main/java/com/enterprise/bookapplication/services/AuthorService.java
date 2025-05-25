package com.enterprise.bookapplication.services;

import com.enterprise.bookapplication.dto.AuthorDto;
import java.util.List;

public interface AuthorService {
  AuthorDto createAuthor(AuthorDto authorDto);

  AuthorDto getById(Integer id);

  List<AuthorDto> getAll(Integer pageNumber, Integer pageSize);

  AuthorDto updateAuthor(Integer id, AuthorDto authorDto);

  void deleteAuthor(Integer id);
}
