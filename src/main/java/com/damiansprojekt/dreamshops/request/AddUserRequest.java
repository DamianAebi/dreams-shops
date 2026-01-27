package com.damiansprojekt.dreamshops.request;

import com.damiansprojekt.dreamshops.model.Order;
import lombok.Data;

import java.util.List;

@Data
public class AddUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
