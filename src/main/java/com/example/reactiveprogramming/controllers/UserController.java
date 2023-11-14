package com.example.reactiveprogramming.controllers;

import com.example.reactiveprogramming.models.UserRequest;
import com.example.reactiveprogramming.models.UserResponse;
import com.example.reactiveprogramming.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Mono<UserResponse> saveUser(@RequestBody UserRequest request)
    {
        return userService.saveUser(request);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<UserResponse> retrieveUsers() {
        return userService.retrieveUsers();
    }

}
