/*
 * To change this license header , choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.services;

import com.wharehouse.wharehouseBE.security.daos.UsersRepository;
import com.wharehouse.wharehouseBE.security.model.entities.Authority;
import com.wharehouse.wharehouseBE.security.model.entities.Users;
import com.wharehouse.wharehouseBE.security.model.pojo.CustomUser;
import static java.util.Collections.emptyList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UsersRepository userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Optional<Users> userOptional = userService.findByUsername(username);
            if (userOptional.isPresent()) {
                Users user = userOptional.get();
                if (user == null) {
                    throw new UsernameNotFoundException(username);
                }
//                if (user.getActive() == 0) {//inactive user
//                    enabled = false;
//                }
                  return new CustomUser(username,
                        user.getPassword(), true, true, true, true, mapToGrantedAuthorities(user.getAuthorities()),
                        user.getId(), user.getFirstName(), user.getLastName(), user.getIsAdmin());
            } else {
                throw new UsernameNotFoundException(username);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
