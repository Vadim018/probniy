package com.example.probniy.repository;

import com.example.probniy.models.Post;
import org.springframework.data.repository.CrudRepository;

// це встроєнний інтерфейс, в якому є всі необхідні функції для виконання певних операцій у проекті
public interface PostRepository extends CrudRepository<Post, Long> {
}
