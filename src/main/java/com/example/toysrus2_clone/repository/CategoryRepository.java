package com.example.toysrus2_clone.repository;

import com.example.toysrus2_clone.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
