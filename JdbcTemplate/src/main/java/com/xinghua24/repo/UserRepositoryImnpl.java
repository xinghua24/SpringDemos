package com.xinghua24.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.xinghua24.entity.User;

@Repository("userRepository")
public class UserRepositoryImnpl implements UserRepository {

    private JdbcTemplate template;

    @Autowired
    public UserRepositoryImnpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> list() {
        String sql = "SELECT id, name, email from users";
        return template.query(sql, new UserRowMapper());
    }

    @Override
    public void insert(User user) {
        String sql = "insert into users(id, name, email) values(null,?,?)";
        template.update(sql, user.getName(), user.getEmail());
    }

    @Override
    public void insertWithIdReturned(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement("insert into users(name, email) values(?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                return statement;
            }
        }, keyHolder);
        user.setId(keyHolder.getKey().intValue());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from users where id = ?";
        template.update(sql, new Object[] { id });
    }

    public static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }
}
