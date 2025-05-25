package com.enterprise.bookapplication.serviceimpl;

import com.enterprise.bookapplication.dao.UserDao;
import com.enterprise.bookapplication.dto.UserDto;
import com.enterprise.bookapplication.entity.User;
import com.enterprise.bookapplication.exceptions.ResourceNotFound;
import com.enterprise.bookapplication.services.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserDao userDao;
  @Autowired private ModelMapper modelMapper;

  @Override
  public UserDto createUser(UserDto userDto) {
    User users = this.modelMapper.map(userDto, User.class);
    User saveusers = this.userDao.save(users);
    return this.modelMapper.map(saveusers, UserDto.class);
  }

  @Override
  public UserDto getById(Integer id) {
    User user = this.userDao.findById(id).orElseThrow(() -> new ResourceNotFound("Users", id));
    return this.modelMapper.map(user, UserDto.class);
  }

  @Override
  public List<UserDto> getAll(Integer pageNumber, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    Page<User> usersPage = this.userDao.findAll(pageable);
    List<User> usersList = usersPage.getContent();
    return usersList
        .stream()
        .map(users -> this.modelMapper.map(users, UserDto.class))
        .collect(Collectors.toList());
  }

  @Override
  public UserDto updateUser(Integer id, UserDto userDto) {
    User UpatedUser =
        this.userDao.findById(id).orElseThrow(() -> new ResourceNotFound("Users", id));
    UpatedUser.setUsername(userDto.getUsername());
    UpatedUser.setEmail(userDto.getEmail());
    UpatedUser.setRole(userDto.getRole());
    User updated = this.userDao.save(UpatedUser);
    return this.modelMapper.map(updated, UserDto.class);
  }

  @Override
  public void deleteUser(Integer id) {
    User user = this.userDao.findById(id).orElseThrow(() -> new ResourceNotFound("Users", id));
    this.userDao.delete(user);
  }
}
