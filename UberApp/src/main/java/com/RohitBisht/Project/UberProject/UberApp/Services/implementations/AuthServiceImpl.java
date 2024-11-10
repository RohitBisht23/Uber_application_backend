package com.RohitBisht.Project.UberProject.UberApp.Services.implementations;

import com.RohitBisht.Project.UberProject.UberApp.DTO.DriverDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.SignUpDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.UserDTO;
import com.RohitBisht.Project.UberProject.UberApp.Services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String logIn(String email, String password) {
        return "";
    }

    @Override
    public UserDTO signUp(SignUpDTO signUpDTO) {
        return null;
    }

    @Override
    public DriverDTO onBoardDriver(Long userId) {
        return null;
    }
}
