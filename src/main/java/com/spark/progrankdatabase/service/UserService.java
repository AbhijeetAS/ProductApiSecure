package com.spark.progrankdatabase.service;

import com.spark.progrankdatabase.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public String addUser(User user);

    public List<User> getAll();

    public String deleteUser(int id);

    public String updateUser(User user);

}
