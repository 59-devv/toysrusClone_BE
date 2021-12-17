package com.example.toysrus2_clone.model;

import com.example.toysrus2_clone.validator.CartValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    @Column
    private Long cartCount;



    public Cart(User user, Long cartCount, Item item) {

        CartValidator.checkCart(user, cartCount, item);

        this.user = user;
        this.cartCount = cartCount;
        this.item = item;
    }

    public void addItemCount(Long count) { this.cartCount += count; }
}