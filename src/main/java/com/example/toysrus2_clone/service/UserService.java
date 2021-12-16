package com.example.toysrus2_clone.service;

import com.example.toysrus2_clone.dto.SignupRequestDto;
import com.example.toysrus2_clone.model.User;
import com.example.toysrus2_clone.repository.UserRepository;
import com.example.toysrus2_clone.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String userRegister(SignupRequestDto signupRequestDto) {

        String username = signupRequestDto.getUsername()+"@"+signupRequestDto.getDomain();
        Optional<User> foundEmail = userRepository.findByUsername(username);
        UserValidator.checkEmail(foundEmail);

        UserValidator.checkPassword(signupRequestDto);
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        User user = new User(signupRequestDto);
        user.setPassword(password);
        userRepository.save(user);


        return "회원가입 성공";
    }
}
