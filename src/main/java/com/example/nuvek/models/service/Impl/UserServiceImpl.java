package com.example.nuvek.models.service.Impl;

import com.example.nuvek.models.entity.User;
import com.example.nuvek.models.repository.UserRepository;
import com.example.nuvek.models.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional()
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional()
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
