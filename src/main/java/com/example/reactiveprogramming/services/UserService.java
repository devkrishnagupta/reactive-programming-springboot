package com.example.reactiveprogramming.services;

import com.example.reactiveprogramming.entity.User;
import com.example.reactiveprogramming.mapper.UserMapper;
import com.example.reactiveprogramming.models.UserRequest;
import com.example.reactiveprogramming.models.UserResponse;
import com.example.reactiveprogramming.repositories.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    final UserMapper userMapper;

    final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public Mono<UserResponse> saveUser(UserRequest request) {
        User user = userMapper.toUser(request);
        Mono<User> customerMono = userRepository.save(user).log();
        return customerMono.map(userMapper::toUserResponse);
    }

    public Flux<UserResponse> retrieveUsers() {
        return userRepository.findAll().log().map(userMapper::toUserResponse);
    }

}
