package com.wharehouse.wharehouseBE.security.utils;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.wharehouse.wharehouseBE.exceptions.BusinessException;
import com.wharehouse.wharehouseBE.security.model.pojo.CustomUser;
import com.wharehouse.wharehouseBE.security.model.entities.Users;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil implements Serializable {

    @Autowired
    private UserDetailsService userDetailsService;

    public void setAuthentication(String username) {
        CustomUser customUser = (CustomUser) this.userDetailsService.loadUserByUsername(username);
        if (customUser.isEnabled() == false) {
            throw new BusinessException("user inactive");
        }

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                customUser, null, customUser.getAuthorities());//
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

    public Optional<CustomUser> getAuthentication() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {

            Object principal = auth.getPrincipal();

            if (principal instanceof CustomUser) // User is your user type that implements UserDetails
            {
                return Optional.of((CustomUser) principal);
            }
        }

        return Optional.empty();
    }

//    public Users findAuthunticatedUser() {
//
//        Optional<CustomUser> currentCustomUser = getAuthentication();
//        if (!currentCustomUser.isPresent()) {
//
//            throw new BusinessException("not authenticated user");
//
//        }
//        CustomUser customUser = currentCustomUser.get();
//
//        return new Users(customUser.getId());
//
//    }
}
