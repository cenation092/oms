package com.assignment.oms.controller;

import com.assignment.oms.dto.*;
import com.assignment.oms.exceptions.AppException;
import com.assignment.oms.model.Role;
import com.assignment.oms.model.RoleName;
import com.assignment.oms.model.User;
import com.assignment.oms.repository.RoleRepository;
import com.assignment.oms.repository.UserRepository;
import com.assignment.oms.security.JwtTokenProvider;
import com.assignment.oms.services.AuthService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiOperation(value = "User SignIn",
            notes = "signin existing user", response = ResponseEntity.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/signin", method = RequestMethod.POST, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticateUser( @RequestBody LoginRequestVO loginRequest) {
        return authService.authenticateUser(loginRequest);
    }

    @ApiOperation(value = "User SignUp",
            notes = "signup new user", response = ResponseEntity.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/signup/user", method = RequestMethod.POST, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequestVO signUpRequest) {
        return authService.registerUser(signUpRequest);
    }

    @ApiOperation(value = "Admin SignUp",
            notes = "signup new admin", response = ResponseEntity.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @RequestMapping(value = "/signup/admin", method = RequestMethod.POST, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<?> registerAdmin(@RequestBody SignUpRequestVO signUpRequest) {
        return authService.registerAdmin(signUpRequest);
    }
}