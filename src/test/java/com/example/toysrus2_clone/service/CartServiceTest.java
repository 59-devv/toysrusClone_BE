package com.example.toysrus2_clone.service;

import com.example.toysrus2_clone.dto.*;
import com.example.toysrus2_clone.model.Cart;
import com.example.toysrus2_clone.model.Category;
import com.example.toysrus2_clone.model.Item;
import com.example.toysrus2_clone.model.User;
import com.example.toysrus2_clone.repository.CartRepository;
import com.example.toysrus2_clone.repository.ItemRepository;
import com.example.toysrus2_clone.repository.UserRepository;
import com.example.toysrus2_clone.security.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    CartRepository cartRepository;
    @Mock
    ItemRepository itemRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    UserDetailsImpl userDetails;

    private User user1;
    private Item item1;
    private Category category1;
    private Long id;
    private Long cartCount;

    @BeforeEach
    void setup(){
        SignupRequestDto signupRequestDto = new SignupRequestDto(
                "정창길",
                "hanghae99",
                "hanghae99.kr",
                "test1234!@",
                "test1234!@",
                "01012341234",
                "스파르타 코딩클럽"
        );
        user1 = new User(signupRequestDto);

        category1 = new Category("크리스마스");

        ItemDto itemDto= new ItemDto(
                "goodn911",
                "http://item.ssgcdn.com/62/52/15/item/1000276155262_i1_1200.jpg",
                "http://www.ssg.com/item/nonSslIframePItemDtlDesc.ssg?itemId=1000018907916",
                15900L,
                category1
        );
        item1 =new Item(itemDto);
        id = 1L;
        cartCount = 1L;

    }

    @Test
    @DisplayName("장바구니 저장")
    void cartSave(){
        //given

        CartService cartService = new CartService(cartRepository,itemRepository,userRepository);

        Cart cart = new Cart(user1,cartCount,item1);

        when(itemRepository.findById(item1.getId()))
                .thenReturn(Optional.of(item1));
        when(cartRepository.findByUserIdAndItem(user1.getId(),item1))
                .thenReturn(Optional.of(cart));

        UserDetailsImpl userDetails = new UserDetailsImpl(user1);
        CartDto cartDto = new CartDto(item1.getId(), cartCount);
        //when

        cartService.cartSave(userDetails,cartDto);

        //then


    }
    @Test
    @DisplayName("장바구니 조회")
    void getCart(){
        //given
        UserDetailsImpl userDetails = new UserDetailsImpl(user1);
        CartService cartService = new CartService(cartRepository,itemRepository,userRepository);

        when(userRepository.findById(user1.getId()))
                .thenReturn(Optional.of(user1));

        Cart cart = new Cart(user1, cartCount, item1);


        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        when(cartRepository.findAllByUserId(user1.getId()))
                .thenReturn(cartList);
        when(itemRepository.findById(cartList.get(0).getItem().getId()))
                .thenReturn(Optional.of(item1));

        //when
        CartResponseDto cart1 = cartService.getCart(userDetails);

        //then
            assertEquals(user1.getId(),cart1.getUserInfo().getUserId());
            assertEquals(user1.getName(),cart1.getUserInfo().getName());
            assertEquals(user1.getAddress(),cart1.getUserInfo().getAddress());
            assertEquals(item1.getItemName(),cart1.getItems().get(0).getItemName());
            assertEquals(item1.getId(),cart1.getItems().get(0).getItemId());
            assertEquals(item1.getThumbnail(),cart1.getItems().get(0).getThumbnail());
            assertEquals(item1.getPrice(),cart1.getItems().get(0).getPrice());
            assertEquals(cartCount,cart1.getItems().get(0).getCount());




        }
    }

