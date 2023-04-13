package com.ohc.model;

import lombok.Data;

import java.util.List;
@Data
public class LoginMessage {
    private List<User> userList;
    private String message;
}
