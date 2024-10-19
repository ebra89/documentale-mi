package org.example.controller;

import jakarta.validation.Valid;
import org.example.dao.model.DocUser;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public DocUser saveUser(@Valid @RequestBody DocUser user)
    {
        return userService.saveUser(user);
    }

    // Read operation
    @GetMapping("/users")
    public List<DocUser> fetchUserList()
    {
        return userService.fetchUserList();
    }


    // Delete operation
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id") Long id)
    {
        userService.deleteUserById(id);
        return "Deleted Successfully";
    }

}
