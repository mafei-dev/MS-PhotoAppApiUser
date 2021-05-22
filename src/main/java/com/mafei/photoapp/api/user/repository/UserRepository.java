package com.mafei.photoapp.api.user.repository;

import com.mafei.photoapp.api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
  @Author Mafei
  @Created 5/23/2021 5:01 AM  
*/
public interface UserRepository extends JpaRepository<User, String> {
}
