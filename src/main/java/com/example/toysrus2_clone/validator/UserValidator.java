package com.example.toysrus2_clone.validator;

import com.example.toysrus2_clone.dto.SignupRequestDto;
import com.example.toysrus2_clone.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Pattern;


@RequiredArgsConstructor
@Component
public class UserValidator {

    public void checkEmail(Optional<User> foundEmail) {
        if(foundEmail.isPresent()){
            throw new IllegalArgumentException ("중복된 이메일이 존재합니다.");
        }
    }
    public void checkPassword(SignupRequestDto signupRequestDto) {
        if (!signupRequestDto.getPassword().equals(signupRequestDto.getPasswordCheck())) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
    }
    public static void checkForm(SignupRequestDto signupRequestDto) {
        if(signupRequestDto.getUsername().trim().equals("")) {
            throw new IllegalArgumentException("아이디는 필수 입력 값 입니다.");
        }
        if(signupRequestDto.getPassword().trim().equals("")) {
            throw new IllegalArgumentException("비밀번호는 필수 입력 값 입니다.");
        }
        if(signupRequestDto.getDomain().trim().equals("")) {
            throw new IllegalArgumentException("이메일은 필수 입력 값 입니다.");
        }
        if(signupRequestDto.getName().trim().equals("")) {
            throw new IllegalArgumentException("이름은 필수 입력 값 입니다.");
        }

        if(signupRequestDto.getPhone().trim().equals("")) {
            throw new IllegalArgumentException("핸드폰번호는 필수 입력 값 입니다.");
        }
        if(signupRequestDto.getAddress().trim().equals("")) {
            throw new IllegalArgumentException("주소는 필수 입력 값 입니다.");
        }

        if(signupRequestDto.getName().contains(" ")) {
            throw new IllegalArgumentException("이름은 공백을 포함할 수 없습니다.");
        }

        if(signupRequestDto.getUsername().contains(" ")) {
            throw new IllegalArgumentException("아이디는 공백을 포함할 수 없습니다.");
        }

        if(signupRequestDto.getDomain().contains(" ")) {
            throw new IllegalArgumentException("도메인은 공백을 포함할 수 없습니다.");
        }

        if(signupRequestDto.getPassword().contains(" ")) {
            throw new IllegalArgumentException("비밀번호는 공백을 포함할 수 없습니다.");
        }

        if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,15}$",signupRequestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호는 8자~15자로 영문, 숫자, 특수문자를 포함해야 합니다.");
        }

        if(!Pattern.matches("^[a-z0-9]{3,12}$",signupRequestDto.getUsername())) {
            throw new IllegalArgumentException("아이디는 소문자,숫자로 이루어진 3~12자여야 합니다.");
        }
        if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,15}$",signupRequestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호는 8자~15자로 영문, 숫자, 특수문자를 포함해야 합니다.");
        }
        if(!Pattern.matches("^[0-9]+$", signupRequestDto.getPhone())) {
            throw new IllegalArgumentException("핸드폰번호는 숫자만 입력 가능합니다.");
        }

    }
}
