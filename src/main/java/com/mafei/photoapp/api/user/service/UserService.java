package com.mafei.photoapp.api.user.service;

import com.mafei.photoapp.api.user.dto.in.UserDto;
import com.mafei.photoapp.api.user.entity.APUser;
import com.mafei.photoapp.api.user.repository.UserRepository;
import com.mafei.photoapp.api.user.resource.TxManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/*
  @Author Mafei
  @Created 5/23/2021 5:02 AM  
*/
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Transactional(transactionManager = TxManager.TX_MANAGER_GLOBAL)
    public APUser addUser(UserDto userDto) {
        String userId = UUID.randomUUID().toString();
        Date date=new Date();
        APUser APUser = new APUser();
        APUser.setUserId(userId);
        APUser.setUserId(userId);
        APUser.setUsername(userDto.getUsername());
        APUser.setFirstName(userDto.getFirstName());
        APUser.setLastName(userDto.getLastName());
        APUser.setPassword(userDto.getPassword());
        APUser.setDatetime(date);
        return userRepository.save(APUser);
    }

}
