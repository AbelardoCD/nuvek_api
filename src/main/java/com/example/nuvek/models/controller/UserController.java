package com.example.nuvek.models.controller;



import com.example.nuvek.models.entity.User;
import com.example.nuvek.models.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins= "http://localhost:4200")
@CrossOrigin
@RestController
@RequestMapping("/api" )
public class UserController {


    @Autowired
    private IUserService userService;
    @GetMapping("/users")
    public List<User> index(){
        return userService.findAll();
    }

    @GetMapping("/user/{username}/{password}")
    public User findUser(@PathVariable String username,@PathVariable String password){
        return userService.findByUsernameAndPassword(username, password);
    }


    @GetMapping("/user/{id}")
    public User show(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user, @PathVariable Long id){
        User currentUser = userService.findById(id);
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        currentUser.setEmail(user.getEmail());
        currentUser.setName(user.getName());

        return userService.save(currentUser);

    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
