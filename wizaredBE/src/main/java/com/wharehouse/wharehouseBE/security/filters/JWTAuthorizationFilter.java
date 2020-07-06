/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.filters;

import com.wharehouse.wharehouseBE.security.services.TokenProvideService;
import com.wharehouse.wharehouseBE.model.ConstantStrings;
import com.wharehouse.wharehouseBE.security.utils.JWTUtil;
import com.wharehouse.wharehouseBE.security.utils.RequestWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 *
 * @author mohamed.abd-elwadod
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

//    public JWTAuthorizationFilter(AuthenticationManager authManager) {
//        super(authManager);
//    }
    TokenProvideService tokenProvideService;

    public JWTAuthorizationFilter(AuthenticationManager authManager, ApplicationContext applicationContext) {
        super(authManager);
        tokenProvideService = applicationContext.getBean(TokenProvideService.class);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        String jwtToken = req.getHeader(HttpHeaders.AUTHORIZATION);

        if (jwtToken == null) {
            chain.doFilter(req, res);
            return;
        }

        // In case if the request come from mobile with encoded body, so we need to decode the request body.
        if (req.getRequestURI().contains(ConstantStrings.SUB_MOBILE_URL)) {
            /**
             * re-write body and decode
             * https://howtodoinjava.com/servlets/httpservletrequestwrapper-example-read-request-body/
             */
            req = new RequestWrapper((HttpServletRequest) req);
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(jwtToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        try {
            //ignore logout service from  token validation which will be check for remove
            if (!req.getRequestURI().contains(ConstantStrings.SUB_LOGOUT_URL)) {
                isValidate(jwtToken);
            }
        } catch (AccessDeniedException e) {
            SecurityContextHolder.clearContext();
            Logger.getLogger("Stolen Token :" + jwtToken).log(Level.SEVERE, null, e);
        }
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String jwtToken) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
        if (jwtToken != null) {
            String user = JWTUtil.getUsernameFromToken(jwtToken, ConstantStrings.SIGNING_KEY);

            List<LinkedHashMap> roles = JWTUtil.getRoles(jwtToken, ConstantStrings.SIGNING_KEY);

            List<SimpleGrantedAuthority> grantedAuthority = null;
            SimpleGrantedAuthority authority = null;
            if (roles != null && !roles.isEmpty()) {
                grantedAuthority = new ArrayList<>();
                for (LinkedHashMap elem : roles) {
                    String authorityString = elem.get("authority").toString();
                    authority = new SimpleGrantedAuthority(authorityString);
                    grantedAuthority.add(authority);
                }
            }
            if (user != null && grantedAuthority != null && !grantedAuthority.isEmpty()) {
                usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, grantedAuthority);
            }

        }
        return usernamePasswordAuthenticationToken;
    }

    private void isValidate(String jwtToken) {
        String user = JWTUtil.getUsernameFromToken(jwtToken, ConstantStrings.SIGNING_KEY);
        int count = tokenProvideService.count(user, jwtToken);
        if (count < 1) {
            throw new AccessDeniedException("Access_Denied");
        }
    }
}
