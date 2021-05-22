package com.mafei.photoapp.api.user.dto.in;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/*
  @Author Mafei
  @Created 5/23/2021 4:22 AM  
*/
@Data
public class UserDto {
    @NotNull(message = "Username is mandatory")
    @NotBlank(message = "Username is mandatory")
    @Email(message = "Invalid email")
    private String username;

    @NotNull(message = "password is mandatory")
    @NotBlank(message = "password is mandatory")
    private String password;

    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotNull(message = "Last name is mandatory")
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
}
