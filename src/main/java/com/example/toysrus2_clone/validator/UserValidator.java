package com.example.toysrus2_clone.validator;

import com.example.toysrus2_clone.dto.SignupRequestDto;
import com.example.toysrus2_clone.model.User;
import com.example.toysrus2_clone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Pattern;


@RequiredArgsConstructor
@Component
public class UserValidator {

    private final UserRepository userRepository;

    public SignupRequestDto checkForm(SignupRequestDto signupRequestDto) {

        // 아이디 유효성 검사
        if(signupRequestDto.getUsername().equals("")) {
            throw new IllegalArgumentException("아이디는 필수 입력 값 입니다");
        }

        if(signupRequestDto.getDomain().equals("")) {
            throw new IllegalArgumentException("이메일 도메인을 선택해주세요.");
        }

        if(!Pattern.matches("^[a-z0-9]{3,12}$",signupRequestDto.getUsername())) {
            throw new IllegalArgumentException("아이디는 소문자,숫자로 이루어진 3~12자여야 합니다.");
        }

        String signupEmail = signupRequestDto.getUsername() + "@" + signupRequestDto.getDomain();
        Optional<User> foundEmail = userRepository.findByUsername(signupEmail);

        if(signupEmail.equals(foundEmail.get().getUsername())) {
            throw new IllegalArgumentException("가입된 Email 주소가 존재합니다.");
        }


        // 비밀번호 유효성 검사
        if(signupRequestDto.getPassword().equals("")) {
            throw new IllegalArgumentException("비밀번호는 필수 입력 값 입니다");
        }

        if (!signupRequestDto.getPasswordCheck().equals(signupRequestDto.getPassword())) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }

        if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,15}$",signupRequestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호는 8자~15자로 영문, 숫자, 특수문자를 포함해야 합니다.");
        }


        // 휴대폰번호 유효성 검사
        if(signupRequestDto.getPhone().equals("")) {
            throw new IllegalArgumentException("휴대폰번호는 필수 입력 값 입니다");
        }
        if(!Pattern.matches("^[0-9]+$", signupRequestDto.getPhone())) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        // 이름 유효성 검사
        if(signupRequestDto.getName().equals("")) {
            throw new IllegalArgumentException("이름은 필수 입력 값 입니다");
        }

        // 주소 유효성 검사
        if(signupRequestDto.getAddress().equals("")) {
            throw new IllegalArgumentException("주소는 필수 입력 값 입니다");
        }

        SignupRequestDto result = signupRequestDto;

        return result;

    }
}
