package com.enterprise.bookapplication.services;

import com.enterprise.bookapplication.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getById(Integer id);

    List<UserDto> getAll(Integer pageNumber, Integer pageSize);

   UserDto updateUser(Integer id, UserDto userDto);

    void deleteUser(Integer id);

}
