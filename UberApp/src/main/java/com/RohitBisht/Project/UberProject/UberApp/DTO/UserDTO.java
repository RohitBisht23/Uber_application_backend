package com.RohitBisht.Project.UberProject.UberApp.DTO;

import com.RohitBisht.Project.UberProject.UberApp.Entity.Enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private  String name;
    private String email;
    private Set<Roles>roles;

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
