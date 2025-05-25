package com.enterprise.bookapplication.controller;


import com.enterprise.bookapplication.dto.ApiResponse;
import com.enterprise.bookapplication.dto.UserDto;
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
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) {
        UserDto savedUser = this.userService.createUser(userDto);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        UserDto user = this.userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAll(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                                @RequestParam(value = "pageSize",defaultValue = "2",required = false)Integer pageSize) {
        List<UserDto> usersList = this.userService.getAll(pageNumber,pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(usersList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        UserDto updateUser = this.userService.updateUser(id, userDto);
        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id) {
        this.userService.deleteUser(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Sucessfully", true), HttpStatus.OK);
    }


}
