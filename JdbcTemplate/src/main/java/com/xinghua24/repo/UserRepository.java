package com.xinghua24.repo;

import java.util.List;

import com.xinghua24.entity.User;

public interface UserRepository {

    List<User> list();

    void delete(int id);

    void insert(User user);

    void insertWithIdReturned(User user);

}