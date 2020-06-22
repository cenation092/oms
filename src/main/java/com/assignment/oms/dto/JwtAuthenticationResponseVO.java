package com.assignment.oms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtAuthenticationResponseVO {
    private String accessToken;
    private String tokenType = "Bearer";
    public JwtAuthenticationResponseVO(String accessToken) {
        this.accessToken = accessToken;
    }
}
