package com.example.liquibase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import lombok.SneakyThrows;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
public class LiquibaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiquibaseDemoApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(JdbcTemplate template) {
		return args -> {
			var sql= """
					select c.id as comment_id,
						   a.id as article_id,
						   c.comment as comment,
						   a.authored as authored,
						   a.title as title
					from articles a
					left join
					comments c
					on a.id = c.article_id
					""";
			var list = template.query(sql, new ArticleRowMapper());
			new HashSet<>(list).forEach(System.out::println);
		};
	}
}

record Article(Long id, String title, Date authored, List<Comment> comments) {
}

record Comment(Long id, String comment) {
}

class ArticleRowMapper implements RowMapper<Article> {
	private final Map<Long, Article> articles = new ConcurrentHashMap<>();

	@Override
	public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
		var articleId = rs.getLong("article_id");
		var commentId = rs.getLong("comment_id");
		var article = this.articles.computeIfAbsent(articleId, aid -> build(aid, rs));
		if(commentId > 0 ) {
			article.comments().add(new Comment(commentId, rs.getString("comment")));
		}
		return article;
	}

	@SneakyThrows
	private Article build(Long aid, ResultSet rs) {
		return new Article(aid, rs.getString("title"), rs.getDate("authored"), new ArrayList<>());
	}
}