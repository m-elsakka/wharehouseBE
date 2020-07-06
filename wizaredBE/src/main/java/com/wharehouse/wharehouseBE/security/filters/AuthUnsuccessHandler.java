/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.filters;


import com.wharehouse.wharehouseBE.model.pojos.ResponsePojo;
import com.wharehouse.wharehouseBE.security.utils.JWTUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author mohamed.abd-elwadod
 */
@Component
public class AuthUnsuccessHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest hsr, HttpServletResponse hsr1, AuthenticationException ae) throws IOException, ServletException {
        ResponsePojo responsePojo = new ResponsePojo();
        responsePojo.setSuccess(false);
        responsePojo.setExceptionMessage(ae.getMessage());

//        ObjectMapper mapper = new ObjectMapper();
//        String responseString = mapper.writeValueAsString(responsePojo);
        String encodedResponse = JWTUtil.encodeJWT(responsePojo, JWTUtil.DEFAULT_KEY.getBytes());

        PrintWriter out = hsr1.getWriter();
        out.print(encodedResponse);
    }

}
