package com.spark.progrankdatabase.service;

import com.spark.progrankdatabase.entity.User;
import com.spark.progrankdatabase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceimplementation implements UserService{

    private UserRepository userRepository;
    public UserServiceimplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       this.userRepository.save(user);
       return "user is added succesfully";
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public String deleteUser(int id) {
        this.userRepository.deleteById(id);
        return "user delete successfully";
    }

    @Override
    public String updateUser(User user) {
        return null;
    }
}
