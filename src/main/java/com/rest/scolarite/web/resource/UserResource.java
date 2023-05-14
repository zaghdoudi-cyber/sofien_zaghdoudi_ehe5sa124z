package com.rest.scolarite.web.resource;

import com.rest.scolarite.domaine.User;
import com.rest.scolarite.security.payload.AuthenticationRequest;
import com.rest.scolarite.security.payload.AuthenticationResponse;
import com.rest.scolarite.security.payload.RegisterRequest;
import com.rest.scolarite.service.implementation.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserResource {
    private final UserServiceImpl userServiceImpl;

    public UserResource(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@Valid @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        AuthenticationResponse jwt = this.userServiceImpl.authenticateUser(authenticationRequest);
        return new ResponseEntity<>(jwt, HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid @RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(this.userServiceImpl.createUser(registerRequest), HttpStatus.CREATED);
    }

}
