package com.assignment.oms.services;

import com.assignment.oms.dto.ApiResponseVO;
import com.assignment.oms.dto.JwtAuthenticationResponseVO;
import com.assignment.oms.dto.LoginRequestVO;
import com.assignment.oms.dto.SignUpRequestVO;
import com.assignment.oms.exceptions.AppException;
import com.assignment.oms.model.Role;
import com.assignment.oms.model.RoleName;
import com.assignment.oms.model.User;
import com.assignment.oms.repository.RoleRepository;
import com.assignment.oms.repository.UserRepository;
import com.assignment.oms.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@Service
public interface AuthService {

    public ResponseEntity<?> authenticateUser(LoginRequestVO loginRequest);

    public ResponseEntity<?> registerUser(SignUpRequestVO signUpRequest);

    public ResponseEntity<?> registerAdmin(SignUpRequestVO signUpRequest);
}
