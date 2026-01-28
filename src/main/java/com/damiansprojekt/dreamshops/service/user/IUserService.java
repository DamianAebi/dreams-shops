package com.damiansprojekt.dreamshops.service.user;

import com.damiansprojekt.dreamshops.model.User;
import com.damiansprojekt.dreamshops.request.AddUserRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(AddUserRequest request);
    void deleteUser(Long userId);
}
