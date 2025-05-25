package com.enterprise.bookapplication.services;

import java.util.List;

public interface UserService {

    com.enterprise.bookapplication.dtos.UserDto createUser(com.enterprise.bookapplication.dtos.UserDto userDto);

    com.enterprise.bookapplication.dtos.UserDto getById(Integer id);

    List<com.enterprise.bookapplication.dtos.UserDto> getAll(Integer pageNumber, Integer pageSize);

   com.enterprise.bookapplication.dtos.UserDto updateUser(Integer id, com.enterprise.bookapplication.dtos.UserDto userDto);

    void deleteUser(Integer id);

}
