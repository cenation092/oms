package com.assignment.oms.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestVO {
    @NonNull
    private String usernameOrEmail;

    @NonNull
    private String password;
}
