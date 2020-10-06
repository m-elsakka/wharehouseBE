/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wharehouse.wharehouseBE.model.ConstantStrings;
import com.wharehouse.wharehouseBE.security.model.entities.Users;
import com.wharehouse.wharehouseBE.security.utils.JWTUtil;
import com.wharehouse.wharehouseBE.security.utils.PasswordUtil;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author mohamed.abd-elwadod
 */
public class JWTAuthenticationMobileFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationMobileFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(ConstantStrings.LOGIN_MOBILE_URL, "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
            HttpServletResponse res) throws AuthenticationException {
        try {

            String requestJWTBody = null;
            requestJWTBody = IOUtils.toString(req.getReader());
            Users user = new ObjectMapper().readValue(requestJWTBody, Users.class);
           // String decrpPassword = PasswordUtil.decrypt(user.getPassword(), user.getUserName().trim());
            res.addHeader(JWTUtil.MOBILE_RES_HEADER_KEY, JWTUtil.DEFAULT_KEY);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName().trim(),
                    user.getPassword(), new ArrayList<>()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
