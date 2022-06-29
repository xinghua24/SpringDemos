package com.example.sampleapp;

import com.example.sampleapp.entity.Comment;
import com.example.sampleapp.entity.Post;
import com.example.sampleapp.repo.CommentRepository;
import com.example.sampleapp.repo.PostRepository;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

  @Autowired
  private PostRepository postRepository;
  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  ConnectionFactory connectionFactory;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner appRunner() {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        System.out.println(connectionFactory);
        postRepository.deleteAll().block();
        commentRepository.deleteAll().block();

        Post post1 = new Post();
        post1.setId(1l);
        post1.setTitle("post1");
        post1.setContent("This is post1!!!!");
        post1.setVisited(1);

        Comment comment1 = new Comment();
        comment1.setAuthorName("John Smith");
        comment1.setContent("This is comment1");

        try {
          postRepository.save(post1).subscribe();
          postRepository.findAll().collectList().block().forEach(System.out::println);
          Comment ret = commentRepository.save(comment1).block();
          commentRepository.findAll().collectList().block().forEach(System.out::println);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    };
  }
}
