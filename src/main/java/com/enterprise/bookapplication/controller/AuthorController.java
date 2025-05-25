package com.enterprise.bookapplication.controller;

import com.enterprise.bookapplication.dto.ApiResponse;
import com.enterprise.bookapplication.dto.AuthorDto;
import com.enterprise.bookapplication.services.AuthorService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
@Validated
public class AuthorController {

  @Autowired private AuthorService authorService;

  @PostMapping("/save")
  public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody AuthorDto authorDto) {
    AuthorDto saveauthor = this.authorService.createAuthor(authorDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(saveauthor);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AuthorDto> getById(@PathVariable Integer id) {
    AuthorDto getAuthor = this.authorService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(getAuthor);
  }

  @GetMapping("/")
  public ResponseEntity<List<AuthorDto>> getAll(
      @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
      @RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize) {
    List<AuthorDto> AuthorList = this.authorService.getAll(pageNumber, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(AuthorList);
  }

  @PutMapping("/{id}")
  public ResponseEntity<AuthorDto> updateAuthor(
      @PathVariable Integer id, @RequestBody AuthorDto authorDto) {
    AuthorDto updateAuthor = authorService.updateAuthor(id, authorDto);
    return new ResponseEntity<AuthorDto>(updateAuthor, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse> deleteuthor(@PathVariable Integer id) {
    this.authorService.deleteAuthor(id);
    return new ResponseEntity<ApiResponse>(
        new ApiResponse("AuthorDeleted Sucessfully", true), HttpStatus.OK);
  }
}
