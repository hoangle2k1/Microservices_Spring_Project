package com.hoangle.identityservice.mapper;

import com.hoangle.identityservice.dto.request.UserCreationRequest;
import com.hoangle.identityservice.dto.request.UserUpdateRequest;
import com.hoangle.identityservice.dto.response.UserResponse;
import com.hoangle.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
    /*Không phải lúc nào 2 object này cũng có cùng properties với nhau
    * vậy thì làm sao để map được 2 field khác nhau này*/
    //@Mapping(source = "firstname", target = "lastname")
    UserResponse toUserResponse(User user);
}
