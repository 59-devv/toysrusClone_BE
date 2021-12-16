package com.example.toysrus2_clone.model;

import com.example.toysrus2_clone.dto.SignupRequestDto;
import com.example.toysrus2_clone.validator.UserValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    public User(SignupRequestDto requestDto){

        UserValidator.checkForm(requestDto);

        this.name= requestDto.getName();
        this.username=requestDto.getUsername()+"@"+requestDto.getDomain();
        this.password=requestDto.getPassword();
        this.phone=requestDto.getPhone();
        this.address=requestDto.getAddress();
    }
}

