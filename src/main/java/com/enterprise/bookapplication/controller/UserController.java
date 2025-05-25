package com.enterprise.bookapplication.controller;


import com.enterprise.bookapplication.dtos.ApiResponse;
import com.enterprise.bookapplication.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<com.enterprise.bookapplication.dtos.UserDto> createUser(@RequestBody @Valid com.enterprise.bookapplication.dtos.UserDto userDto) {
        com.enterprise.bookapplication.dtos.UserDto savedUser = this.userService.createUser(userDto);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.UserDto> getById(@PathVariable Integer id) {
        com.enterprise.bookapplication.dtos.UserDto user = this.userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/")
    public ResponseEntity<List<com.enterprise.bookapplication.dtos.UserDto>> getAll(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                                                                        @RequestParam(value = "pageSize",defaultValue = "2",required = false)Integer pageSize) {
        List<com.enterprise.bookapplication.dtos.UserDto> usersList = this.userService.getAll(pageNumber,pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(usersList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.UserDto> updateUser(@PathVariable Integer id, @RequestBody com.enterprise.bookapplication.dtos.UserDto userDto) {
        com.enterprise.bookapplication.dtos.UserDto updateUser = this.userService.updateUser(id, userDto);
        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<com.enterprise.bookapplication.dtos.ApiResponse> deleteUser(@PathVariable Integer id) {
        this.userService.deleteUser(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Sucessfully", true), HttpStatus.OK);
    }


}
