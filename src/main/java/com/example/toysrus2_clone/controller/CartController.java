package com.example.toysrus2_clone.controller;

import com.example.toysrus2_clone.dto.CartDto;
import com.example.toysrus2_clone.dto.CartResponseDto;
import com.example.toysrus2_clone.security.UserDetailsImpl;
import com.example.toysrus2_clone.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartController {

    public final CartService cartService;

    @PostMapping("/api/cart")
    public void cartSave(@RequestBody CartDto cartDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        String name = userDetails.getUser().getName();
        if (name==null) {
            throw new IllegalArgumentException("로그인 사용자만 이용할 수 있습니다.");
        }
        cartService.cartSave(userDetails, cartDto);
    }

    @GetMapping("/api/cart")
    public CartResponseDto getCart(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return cartService.getCart(userDetails);
    }
}
