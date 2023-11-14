package com.example.reactiveprogramming.mapper;

import com.example.reactiveprogramming.entity.User;
import com.example.reactiveprogramming.models.UserRequest;
import com.example.reactiveprogramming.models.UserResponse;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {
    UserResponse toUserResponse(User destination);
    User toUser(UserRequest request);
}
