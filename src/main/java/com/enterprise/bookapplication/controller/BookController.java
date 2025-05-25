package com.enterprise.bookapplication.controller;

import com.enterprise.bookapplication.dto.ApiResponse;
import com.enterprise.bookapplication.dto.BookDto;
import com.enterprise.bookapplication.dto.BookResponse;
import com.enterprise.bookapplication.services.BookService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@Validated
public class BookController {

  @Autowired private BookService bookService;

  @PostMapping("/save")
  public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto) {
    BookDto createBook = bookService.createBook(bookDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createBook);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDto> getById(@PathVariable Integer id) {
    BookDto getBook = bookService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(getBook);
  }

  @GetMapping("/")
  public ResponseEntity<BookResponse> getAll(
      @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
      @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
      @RequestParam(value = "sortDirec", defaultValue = "asc", required = false) String sortDirec) {
    BookResponse getAllbooks = this.bookService.getAll(pageNumber, pageSize, sortBy, sortDirec);
    return ResponseEntity.status(HttpStatus.OK).body(getAllbooks);
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookDto> updateBook(
      @PathVariable Integer id, @RequestBody BookDto bookDto) {
    BookDto updatebook = this.bookService.updateBook(id, bookDto);
    return new ResponseEntity<BookDto>(updatebook, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse> deleteBook(@PathVariable Integer id) {
    this.bookService.deletebook(id);
    return new ResponseEntity<ApiResponse>(
        new ApiResponse("Book deleted Succesfully", true), HttpStatus.OK);
  }

  @GetMapping("/author/{id}")
  public ResponseEntity<List<BookDto>> getByAuthor(@PathVariable Integer id) {
    List<BookDto> bookList = this.bookService.findByAuthor(id);
    return ResponseEntity.status(HttpStatus.OK).body(bookList);
  }

  @GetMapping("/category/{id}")
  public ResponseEntity<List<BookDto>> getByCategory(@PathVariable Integer id) {
    List<BookDto> bookDtos = this.bookService.findByCategory(id);
    return ResponseEntity.status(HttpStatus.OK).body(bookDtos);
  }
}
