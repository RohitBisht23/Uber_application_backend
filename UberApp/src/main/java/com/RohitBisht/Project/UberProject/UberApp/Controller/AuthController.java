package com.RohitBisht.Project.UberProject.UberApp.Controller;


import com.RohitBisht.Project.UberProject.UberApp.DTO.SignUpDTO;
import com.RohitBisht.Project.UberProject.UberApp.DTO.UserDTO;
import com.RohitBisht.Project.UberProject.UberApp.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/auth")
public class AuthController {
    
    private final AuthService authService;
    @PostMapping("/signUp")
    public ResponseEntity<UserDTO> signUpUser(@RequestBody SignUpDTO signUp) {
        return ResponseEntity.ok(authService.signUp(signUp));
    }
    
}
