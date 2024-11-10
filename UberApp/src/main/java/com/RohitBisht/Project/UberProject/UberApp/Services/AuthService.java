package com.RohitBisht.Project.UberProject.UberApp.Services;

import com.RohitBisht.Project.UberProject.UberApp.DTO.DriverDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.SignUpDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.UserDTO;

public interface AuthService {
    String logIn(String email, String password);

    UserDTO signUp(SignUpDTO signUpDTO);

    DriverDTO onBoardDriver(Long userId);
}
