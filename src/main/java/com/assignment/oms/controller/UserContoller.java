package com.assignment.oms.controller;

import com.assignment.oms.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserContoller {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "Delete user account",
            notes = "Delete existing user account", response = void.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header") })
    @RequestMapping(value = "/managed-users/{userId}", method = RequestMethod.DELETE, produces = {APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN')")
    public void removeUser(@PathVariable Long userId ){
        userRepository.deleteById(userId);
    }

    @ApiOperation(value = "Get user",
            notes = "Delete existing user account", response = void.class,
            produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header") })
    @RequestMapping(value = "/userid", method = RequestMethod.DELETE, produces = {APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN')")
    public void removeUser(){

    }
}
