package com.example.sampleapp.repo;

import com.example.sampleapp.entity.Comment;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends R2dbcRepository<Comment, Long> {
}