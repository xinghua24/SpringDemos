package com.example.sampleapp.repo;

import com.example.sampleapp.entity.Post;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends R2dbcRepository<Post, Long> {
}