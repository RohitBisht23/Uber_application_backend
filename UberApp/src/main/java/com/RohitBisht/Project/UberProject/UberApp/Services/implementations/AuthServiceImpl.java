package com.RohitBisht.Project.UberProject.UberApp.Services.implementations;

import com.RohitBisht.Project.UberProject.UberApp.DTO.DriverDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.SignUpDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.UserDTO;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.Roles;
import com.RohitBisht.Project.UberProject.UberApp.Entity.Rider;
import com.RohitBisht.Project.UberProject.UberApp.Entity.User;
import com.RohitBisht.Project.UberProject.UberApp.Exceptions.RuntimeConflictException;
import com.RohitBisht.Project.UberProject.UberApp.Repository.UserRepository;
import com.RohitBisht.Project.UberProject.UberApp.Services.AuthService;
import com.RohitBisht.Project.UberProject.UberApp.Services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    @Override
    public String logIn(String email, String password) {
        return "";
    }

    @Override
    public UserDTO signUp(SignUpDTO signUpDTO) {
        User user = userRepository.findByEmail(signUpDTO.getEmail()).orElseThrow(() ->new RuntimeConflictException("User already exist with email :"+signUpDTO.getEmail()));

        User newUser = modelMapper.map(signUpDTO, User.class);
        newUser.setRoles(Set.of(Roles.RIDER));

        User savedUser = userRepository.save(newUser);

        //Creating user related entities
        Rider rider = riderService.createNewRider(savedUser);

        //TODO add wallet related service here

        return modelMapper.map(savedUser, UserDTO.class);
        
    }

    @Override
    public DriverDTO onBoardDriver(Long userId) {
        return null;
    }
}
