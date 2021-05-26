package com.example.demo.SERVER.repository;

import com.example.demo.SERVER.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findCategoryById(Long id);
}
