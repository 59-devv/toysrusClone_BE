package com.example.toysrus2_clone.service;

import com.example.toysrus2_clone.dto.LoginRequestDto;
import com.example.toysrus2_clone.dto.SignupRequestDto;
import com.example.toysrus2_clone.model.User;
import com.example.toysrus2_clone.repository.UserRepository;
import com.example.toysrus2_clone.security.UserDetailsImpl;
import com.example.toysrus2_clone.security.jwt.JwtTokenUtils;
import com.example.toysrus2_clone.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserValidator userValidator;

    @Transactional
    public String userRegister(SignupRequestDto signupRequestDto) {

        String username = signupRequestDto.getUsername()+"@"+signupRequestDto.getDomain();
        Optional<User> foundEmail = userRepository.findByUsername(username);
        userValidator.checkEmail(foundEmail);

        userValidator.checkPassword(signupRequestDto);
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        User user = new User(signupRequestDto);
        user.setPassword(password);
        userRepository.save(user);

        return "회원가입 성공";
    }

    public void login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        User user = userRepository.findByUsername(loginRequestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("아이디가 없습니다."));

        if(!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("비밀번호를 확인해주세요.");
        }

        UserDetailsImpl userDetails = new UserDetailsImpl(user);
        String token = JwtTokenUtils.generateJwtToken(userDetails);
        response.addHeader("Authorization", "Bearer " + token);
    }
}
