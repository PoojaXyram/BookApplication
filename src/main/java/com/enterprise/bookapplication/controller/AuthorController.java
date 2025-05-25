package com.enterprise.bookapplication.controller;


import com.enterprise.bookapplication.dtos.AuthorDto;
import com.enterprise.bookapplication.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/author")
@Validated
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public ResponseEntity<com.enterprise.bookapplication.dtos.AuthorDto> createAuthor
            (@Valid @RequestBody com.enterprise.bookapplication.dtos.AuthorDto authorDto) {
        com.enterprise.bookapplication.dtos.AuthorDto saveauthor = this.authorService.createAuthor(authorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveauthor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.AuthorDto> getById(@PathVariable Integer id) {
        com.enterprise.bookapplication.dtos.AuthorDto getAuthor = this.authorService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(getAuthor);
    }

    @GetMapping("/")
    public ResponseEntity<List<com.enterprise.bookapplication.dtos.AuthorDto>>
    getAll(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
           @RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize) {
        List<com.enterprise.bookapplication.dtos.AuthorDto> AuthorList = this.authorService.getAll(pageNumber, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(AuthorList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.AuthorDto>
    updateAuthor(@PathVariable Integer id, @RequestBody AuthorDto authorDto) {
        com.enterprise.bookapplication.dtos.AuthorDto updateAuthor = authorService.updateAuthor(id, authorDto);
        return new ResponseEntity<AuthorDto>(updateAuthor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.ApiResponse> deleteuthor(@PathVariable Integer id) {
        this.authorService.deleteAuthor(id);
        return new ResponseEntity<com.enterprise.bookapplication.dtos.ApiResponse>(new com.enterprise.bookapplication.dtos.ApiResponse("AuthorDeleted Sucessfully", true), HttpStatus.OK);
    }


}
