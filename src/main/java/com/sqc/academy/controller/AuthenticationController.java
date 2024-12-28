package com.sqc.academy.controller;

import com.nimbusds.jose.JOSEException;
import com.sqc.academy.dto.authentication.AuthenticationRequest;
import com.sqc.academy.dto.authentication.AuthenticationResponse;
import com.sqc.academy.dto.authentication.IntrospectRequest;
import com.sqc.academy.dto.authentication.IntrospectResponse;
import com.sqc.academy.service.IAuthenticationService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController // json
@AllArgsConstructor // DI
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/auth")
public class AuthenticationController {
    IAuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return authenticationService.authenticate(authenticationRequest);
    }

    @PostMapping("/introspect")
    public IntrospectResponse introspect(@RequestBody IntrospectRequest introspectRequest) throws ParseException, JOSEException {
        return authenticationService.introspect(introspectRequest);
    }
}
