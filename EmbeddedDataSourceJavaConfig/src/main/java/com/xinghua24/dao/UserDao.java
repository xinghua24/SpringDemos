package com.xinghua24.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xinghua24.entity.User;

@Component
public class UserDao {
	
    private DataSource dataSource;
    
    @Autowired
    public UserDao(DataSource dataSource){
    	this.dataSource = dataSource;
    }

    public List<User> query() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement queryStatement = null;
        try {
            connection = dataSource.getConnection();
            queryStatement = connection.createStatement();
            ResultSet rs = queryStatement.executeQuery("SELECT id, name, email from users");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (queryStatement != null) {
                    queryStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return users;
    }
}
