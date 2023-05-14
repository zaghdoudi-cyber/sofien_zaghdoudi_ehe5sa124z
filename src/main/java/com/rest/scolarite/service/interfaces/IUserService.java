package com.rest.scolarite.service.interfaces;

import com.rest.scolarite.domaine.User;
import com.rest.scolarite.security.payload.AuthenticationRequest;
import com.rest.scolarite.security.payload.AuthenticationResponse;
import com.rest.scolarite.security.payload.RegisterRequest;

public interface IUserService {

    AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest) throws Exception;

    User createUser(RegisterRequest registerRequest);
}
