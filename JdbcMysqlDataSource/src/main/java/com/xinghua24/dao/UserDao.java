package com.xinghua24.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinghua24.entity.User;

public class UserDao {
    public DataSource dataSource;
    
    public List<User> query(){
        List<User> users = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement queryStatement =  connection.createStatement();
            ResultSet rs = queryStatement.executeQuery("SELECT user_id, username, password from user" );
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
