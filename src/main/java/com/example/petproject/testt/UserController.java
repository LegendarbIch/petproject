package com.example.petproject.testt;

import com.example.petproject.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    Map<Long, Userr> users = new HashMap<>();
    private Long id = 1L;
    @GetMapping
    public String getUsers() {
        return users.toString();
    }
    @PostMapping
    public Userr addUser(@RequestBody Userr userr) throws UserAlreadyExistException, InvalidEmailException {

        if (userr.equals(users.get(id))) {
            throw new UserAlreadyExistException("пользователь с таким email уже существует");
        }
        if (userr.getEmail() == null) {
            throw new InvalidEmailException("email не был введен");
        }

        if (!users.isEmpty()) {
            id++;
            users.put(id, userr);
        } else {
            users.put(id, userr);
        }
        return userr;
    }
}
