package com.thoughtmechanix.authentication.controllers;


import com.thoughtmechanix.authentication.exception.InvalidAuthToken;
import com.thoughtmechanix.authentication.model.AuthenticationToken;
import com.thoughtmechanix.authentication.model.UserCredentials;
import com.thoughtmechanix.authentication.model.UserInfo;
import com.thoughtmechanix.authentication.utils.UserContext;
import org.fluentd.logger.FluentLogger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="v1")
public class AuthenticationServiceController {
    private static FluentLogger FLOG = FluentLogger.getLogger("tmx.authenticationservice", "fluentd", 24224);
    private Map<String,UserInfo> validUsers = new HashMap<String,UserInfo>();

    @RequestMapping(value="/validate/{token}",method = RequestMethod.GET)
    public UserInfo validateToken( @PathVariable("token") String token) {


        UserContext.flog(String.format("Validating auth token: %s", token));

        UserInfo userInfo = validUsers.get(token);

        if (userInfo==null){
           throw new InvalidAuthToken();
        }
        return userInfo;
    }

    @RequestMapping(value="/authenticate",method = RequestMethod.POST)
    public AuthenticationToken authenticateCredentials( @RequestBody UserCredentials userCredentials) {
        AuthenticationToken token = new AuthenticationToken();

        token.setAuthToken( java.util.UUID.randomUUID().toString());

        UserInfo userInfo = new UserInfo();
        userInfo.setOrganizationId( java.util.UUID.randomUUID().toString());
        userInfo.setUserId(java.util.UUID.randomUUID().toString());
        validUsers.put(token.getAuthToken(),userInfo);

        return token;
    }
}
