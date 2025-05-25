package com.enterprise.bookapplication.controller;


import com.enterprise.bookapplication.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/book")
@Validated
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/save")
    public ResponseEntity<com.enterprise.bookapplication.dtos.BookDto> createBook(@Valid @RequestBody com.enterprise.bookapplication.dtos.BookDto bookDto) {
        com.enterprise.bookapplication.dtos.BookDto createBook = bookService.createBook(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.BookDto> getById(@PathVariable Integer id) {
        com.enterprise.bookapplication.dtos.BookDto getBook = bookService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(getBook);
    }

    @GetMapping("/")
    public ResponseEntity<com.enterprise.bookapplication.dtos.BookResponse> getAll(@RequestParam(value="pageNumber",defaultValue = "1",required = false)Integer pageNumber
            , @RequestParam(value = "pageSize",defaultValue = "5",required = false)Integer pageSize,
                                                                                   @RequestParam(value = "sortBy",defaultValue = "id",required = false)String sortBy,
                                                                                   @RequestParam (value = "sortDirec",defaultValue = "asc",required = false)String sortDirec) {
        com.enterprise.bookapplication.dtos.BookResponse getAllbooks = this.bookService
                .getAll(pageNumber,pageSize,sortBy,sortDirec);
        return ResponseEntity.status(HttpStatus.OK).body(getAllbooks);

    }

    @PutMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.BookDto> updateBook(@PathVariable Integer id, @RequestBody com.enterprise.bookapplication.dtos.BookDto bookDto) {
        com.enterprise.bookapplication.dtos.BookDto updatebook = this.bookService.updateBook(id, bookDto);
        return new ResponseEntity<com.enterprise.bookapplication.dtos.BookDto>(updatebook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.ApiResponse> deleteBook(@PathVariable Integer id) {
        this.bookService.deletebook(id);
        return new ResponseEntity<com.enterprise.bookapplication.dtos.ApiResponse>(new com.enterprise.bookapplication.dtos.ApiResponse("Book deleted Succesfully", true), HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<com.enterprise.bookapplication.dtos.BookDto>> getByAuthor(@PathVariable Integer id){
        List<com.enterprise.bookapplication.dtos.BookDto>bookList=this.bookService.findByAuthor(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<com.enterprise.bookapplication.dtos.BookDto>> getByCategory(@PathVariable Integer id){
        List<com.enterprise.bookapplication.dtos.BookDto> bookDtos=this.bookService.findByCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookDtos);
    }



}

