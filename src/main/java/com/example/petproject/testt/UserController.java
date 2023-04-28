package com.example.petproject.testt;

import com.example.petproject.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    Map<String, String> users = new HashMap<>();
    @GetMapping
    public String getUsers() {
        return users.toString();
    }
    @PostMapping
    public void addUser(Userr userr) throws UserAlreadyExistException, InvalidEmailException {

        if (userr.getEmail().equals(users.get(userr.getEmail()))) {
            throw new UserAlreadyExistException("пользователь с таким email уже существует");
        }
        if (userr.getEmail().isEmpty()) {
            throw new InvalidEmailException("email не был введен");
        }
    }
}
