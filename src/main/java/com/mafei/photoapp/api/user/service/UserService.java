package com.mafei.photoapp.api.user.service;

import com.mafei.photoapp.api.user.dto.in.UserDto;
import com.mafei.photoapp.api.user.entity.User;
import com.mafei.photoapp.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/*
  @Author Mafei
  @Created 5/23/2021 5:02 AM  
*/
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Transactional
    public User addUser(UserDto userDto) {
        String userId = UUID.randomUUID().toString();
        User user = new User();
        user.setUserId(userId);
        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        return userRepository.save(user);
    }

}
