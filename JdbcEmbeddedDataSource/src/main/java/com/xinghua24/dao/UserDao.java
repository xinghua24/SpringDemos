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
            ResultSet rs = queryStatement.executeQuery("SELECT id, name, email from users" );
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
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
