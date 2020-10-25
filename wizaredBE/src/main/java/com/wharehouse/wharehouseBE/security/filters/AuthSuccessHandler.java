/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.filters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wharehouse.wharehouseBE.security.model.entities.Tokens;
import com.wharehouse.wharehouseBE.security.model.pojo.CustomUser;
import com.wharehouse.wharehouseBE.security.services.TokenProvideService;
import com.wharehouse.wharehouseBE.model.ConstantStrings;
import com.wharehouse.wharehouseBE.model.pojos.ResponsePojo;
import com.wharehouse.wharehouseBE.security.model.pojo.UserLoginResponse;
import com.wharehouse.wharehouseBE.security.utils.JWTUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

//    @Autowired
//    UsersService userService;
    @Autowired
    TokenProvideService tokenProvideService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication authResult) throws IOException, ServletException {
        PrintWriter out = hsr1.getWriter();
        boolean isMobile = hsr.getRequestURI().contains(ConstantStrings.SUB_MOBILE_URL);
        out.print(prepareUserLoginResponse(authResult, isMobile));
    }

    private void prepareFailLoginResponsePojo(ResponsePojo responsePojo, boolean isMobile, boolean hasRole) {
        responsePojo.setSuccess(false);
        if (isMobile) {
            responsePojo.setExceptionMessage("You don't have access to mobile app");
        } else {
            responsePojo.setExceptionMessage("You don't have access to webapp");
        }

    }

    private String prepareUserLoginResponse(Authentication authResult, boolean isMobile)
            throws JsonProcessingException {
        boolean hasRole;
        ResponsePojo responsePojo = new ResponsePojo();
        List<String> authoritiesList = new ArrayList<>();
        CustomUser customUser = ((CustomUser) authResult.getPrincipal());
        authoritiesList.add("ROLE_ADMIN");

        if (isMobile) {
            authoritiesList.add("ROLE_SALES_FORCE");
        } else {
            authoritiesList.add("ROLE_MASTERDATA");
            authoritiesList.add("ROLE_REPORTS");
            authoritiesList.add("ROLE_USERMANAGEMENT");

        }

        hasRole = checkAuthority(new ArrayList(customUser.getAuthorities()), authoritiesList);

        if (!hasRole) {
            prepareFailLoginResponsePojo(responsePojo, isMobile, hasRole);

        } else {
            String fullName = "";
            String jwtToken = JWTUtil.generateToken(customUser.getUsername(), customUser.getAuthorities().toArray());
            createTokenInDB(jwtToken);
            if (customUser.getFirstName() != null) {
                fullName += customUser.getFirstName();
            }
            fullName += " ";
            if (customUser.getLastName() != null) {
                fullName += customUser.getLastName();
            }
            UserLoginResponse userLoginResponse = new UserLoginResponse();
            userLoginResponse.setToken(jwtToken);
            userLoginResponse.setFullName(fullName);
            userLoginResponse.setId(customUser.getId());
            userLoginResponse.setBranchno(customUser.getBranchNo());
            List authorities = new ArrayList(customUser.getAuthorities());
            userLoginResponse.setAuthorities(authorities);
            userLoginResponse.setStkCabinetList(customUser.getStkAccountseList());
            responsePojo.setSuccess(true);
            responsePojo.setData(userLoginResponse);
        }
        String encodedResponse = JWTUtil.encodeJWT(responsePojo, JWTUtil.DEFAULT_KEY.getBytes());
        return encodedResponse;
    }

    private boolean checkAuthority(List<GrantedAuthority> authorities, List authoritiesList) {
        boolean hasAuthority = false;
        for (GrantedAuthority authority : authorities) {
            if (authoritiesList.contains(authority.getAuthority())) {
                hasAuthority = true;
                break;
            }
        }
        return hasAuthority;
    }

    private void createTokenInDB(String token) {
        Tokens validateToken = new Tokens();
        validateToken.setToken(token);
        validateToken.setUserName(JWTUtil.getUsernameFromToken(token, ConstantStrings.SIGNING_KEY));
        validateToken.setIssuedDate(new Date());
        tokenProvideService.create(validateToken);
    }

}
