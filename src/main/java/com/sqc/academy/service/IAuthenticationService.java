package com.sqc.academy.service;

import com.nimbusds.jose.JOSEException;
import com.sqc.academy.dto.authentication.AuthenticationRequest;
import com.sqc.academy.dto.authentication.AuthenticationResponse;
import com.sqc.academy.dto.authentication.IntrospectRequest;
import com.sqc.academy.dto.authentication.IntrospectResponse;

import java.text.ParseException;

public interface IAuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    IntrospectResponse introspect(IntrospectRequest introspectRequest) throws ParseException, JOSEException;
}
