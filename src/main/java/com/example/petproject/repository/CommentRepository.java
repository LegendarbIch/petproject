package com.example.petproject.repository;

import com.example.petproject.entity.Comment;
import com.example.petproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);
    Comment findByIdAndUserId(Long id, Long userId);
}
