package com.demo.swagger.users;


import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserDaoService service;
    //GET /users
    // retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers()
    {
        return service.findALL();
    }

    //GET /user/{id}
    //retrieveUser
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user =service.findOne(id);
        return user;
    }
    
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest){
        User user = new User();
        user.setDob(userRequest.getDob());
        user.setName(userRequest.getName());
        User savedUser=service.save(user);
        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
