package com.mafei.photoapp.api.user.controller;

import com.mafei.photoapp.api.user.dto.in.UserDto;
import com.mafei.photoapp.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
  @Author Mafei
  @Created 5/23/2021 4:27 AM  
*/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody @Validated UserDto userDto) {
        return ResponseEntity.ok().body(userService.addUser(userDto));
    }
}
