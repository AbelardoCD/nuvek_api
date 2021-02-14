package com.example.nuvek.models.repository;

import com.example.nuvek.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    User findByUsernameAndPassword(String username , String password);
}
