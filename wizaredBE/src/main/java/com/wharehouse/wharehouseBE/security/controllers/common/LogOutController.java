/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.controllers.common;

import com.wharehouse.wharehouseBE.controllers.BaseRestController;
import com.wharehouse.wharehouseBE.model.enums.ResponseMessageEnum;
import com.wharehouse.wharehouseBE.security.model.entities.Tokens;
import com.wharehouse.wharehouseBE.security.services.TokenProvideService;
import com.wharehouse.wharehouseBE.model.ConstantStrings;
import com.wharehouse.wharehouseBE.security.model.entities.Users;
import com.wharehouse.wharehouseBE.security.utils.JWTUtil;
import java.util.Base64;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rawan.Ahmed
 */
@RestController
@RequestMapping("/logoutservice")
public class LogOutController extends BaseRestController<Users> {
    
    @Autowired
    TokenProvideService tokenProvideService;

    public LogOutController() {
        findOnlyService();
    }
    

    
// <editor-fold defaultstate="collapsed" desc="WEB_LOGOUT"> 
@RequestMapping(value = "/web/logout", method = RequestMethod.DELETE)
 public ResponseEntity webLogout(HttpServletRequest request,HttpServletResponse response,@RequestHeader(value = HttpHeaders.AUTHORIZATION) String headerAuthorization){
    try
    {
        prepareLogout(request);
        return buildResponseEntity(true, null, ResponseMessageEnum.SUCCESS.getMessage(), HttpStatus.OK, headerAuthorization);
    }
        catch (Exception exception) {
            return buildExceptionResponseEntity(exception, headerAuthorization);
        }
    }
    

//</editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="MOBILE_LOGOUT"> 
    @RequestMapping(value = "/mobile/logout", method = RequestMethod.DELETE)
    public ResponseEntity mobileLogout(HttpServletRequest request,HttpServletResponse response,@RequestHeader(value = HttpHeaders.AUTHORIZATION) String headerAuthorization){
    try
    {      
        prepareLogout(request);
        return buildResponseEntity(true, null, ResponseMessageEnum.SUCCESS.getMessage(), HttpStatus.OK, headerAuthorization);
    }
    catch (Exception exception) {
        return buildExceptionResponseEntity(exception, headerAuthorization);
    }
    }

    //</editor-fold>
    
    
    private void prepareLogout(HttpServletRequest request)
    {
        HttpSession session= request.getSession(false);
        SecurityContextHolder.clearContext();
        session= request.getSession(false);
        String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        String userName = JWTUtil.getUsernameFromToken(jwtToken, ConstantStrings.SIGNING_KEY);
        Tokens validToken = tokenProvideService.findByUserNameAndToken(userName, jwtToken);
        if(validToken != null)
        {
            tokenProvideService.delete(validToken);
        }
        if(session != null) {
            session.invalidate();
        }
        if(request.getCookies() != null)
        {
            for(Cookie cookie : request.getCookies()) {
                cookie.setMaxAge(0);
            }
        }
    }       
            
    
}
