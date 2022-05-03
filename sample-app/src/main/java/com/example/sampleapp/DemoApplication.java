package com.example.sampleapp;

import com.example.sampleapp.entity.Comment;
import com.example.sampleapp.entity.Post;
import com.example.sampleapp.repo.CommentRepository;
import com.example.sampleapp.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Properties;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner appRunner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Post post1 = new Post();
				post1.setTitle("post1");
				post1.setContent("This is post1!!!!");
				post1.setCreateTime(new Date());
				post1.setUpdateTime(new Date());
				post1.setVisited(1);

				Comment comment1 = new Comment();
				comment1.setPost(post1);
				comment1.setAuthorName("John Smith");
				comment1.setContent("This is comment1");
				comment1.setCreateTime(new Date());

				postRepository.save(post1);
				commentRepository.save(comment1);
			}
		};
	}
}
