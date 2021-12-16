package com.example.toysrus2_clone.repository;

import com.example.toysrus2_clone.model.Cart;
import com.example.toysrus2_clone.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {

    Optional<Cart> findByUserIdAndItem(Long id, Item item);
    List<Cart> findAllByUserId(Long userId);
}
