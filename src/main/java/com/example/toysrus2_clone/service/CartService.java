package com.example.toysrus2_clone.service;

import com.example.toysrus2_clone.dto.CartDto;
import com.example.toysrus2_clone.dto.CartItemDto;
import com.example.toysrus2_clone.dto.CartResponseDto;
import com.example.toysrus2_clone.dto.CartUserInfoDto;
import com.example.toysrus2_clone.model.Cart;
import com.example.toysrus2_clone.model.Item;
import com.example.toysrus2_clone.model.User;
import com.example.toysrus2_clone.repository.CartRepository;
import com.example.toysrus2_clone.repository.ItemRepository;
import com.example.toysrus2_clone.repository.UserRepository;
import com.example.toysrus2_clone.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {
    public final CartRepository cartRepository;
    public final ItemRepository itemRepository;
    public final UserRepository userRepository;

    @Transactional
    public void cartSave(UserDetailsImpl userDetails, CartDto cartDto) {
        Long userId=userDetails.getUser().getId();
        //상품 확인
        Item item = itemRepository.findById(cartDto.getItemId()).orElseThrow(
                ()-> new IllegalArgumentException("상품이 없습니다.")
        );
        //장바구니 확인
        Cart cart = cartRepository.findByUserIdAndItem(userId, item).orElse(null);

        if(cart==null) {
            //없다면 상품 추가
            cart = new Cart(userDetails.getUser(), cartDto.getCount(), item);
        }else {
            //있다면 갯수 추가
            cart.addItemCount(cartDto.getCount());
        }
        cartRepository.save(cart);
    }

    @Transactional
    public CartResponseDto getCart(UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();

        User user = userRepository.findById(userId).orElseThrow(
                ()-> new IllegalArgumentException("해당 유저가 없습니다.")
        );
        //유저정보 dto
        CartUserInfoDto cartUserInfoDto = new CartUserInfoDto(userId,user.getName(),user.getAddress());
        //상품 정보
        List<CartItemDto> cartItemDtoList = new ArrayList<>();

        //count,itemId 뽑아 쓰기
        List<Cart> cartList = cartRepository.findAllByUserId(userId);

        for(int i = 0 ; i < cartList.size();i++) {


            Cart cart = new Cart(userDetails.getUser(),cartList.get(i).getCartCount(),cartList.get(i).getItem());

            Item item = itemRepository.findById(cartList.get(i).getItem().getId()).orElseThrow(
                    () -> new IllegalArgumentException("해당 상품이 없습니다.")
            );

            CartItemDto cartItemDto = new CartItemDto(item.getId(),item.getItemName(),item.getThumbnail(), item.getPrice(),cart.getCartCount());
            cartItemDtoList.add(cartItemDto);
        }


        CartResponseDto cartResponseDto = new CartResponseDto(cartUserInfoDto,cartItemDtoList);

        return cartResponseDto;
    }
}
