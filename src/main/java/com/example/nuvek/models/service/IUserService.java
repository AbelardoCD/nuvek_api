package com.example.nuvek.models.service;

import com.example.nuvek.models.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IUserService {

    User findByUsernameAndPassword(String username, String password);

    public List<User> findAll();

    public User findById(Long id);

    public User save(User user);

    public void delete(Long id);
}
