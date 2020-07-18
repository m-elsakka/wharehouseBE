/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.model.pojo;

import java.util.Collection;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author rehab.abd-elhamid
 */
//http://javahotpot.blogspot.com.eg/2013/12/spring-security-adding-more-information.html
public class CustomUser extends User {

    private static final long serialVersionUID = -3531439484732724601L;
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final short isAdmin;
    private final String branchNo;

    public CustomUser(String username, String password, boolean enabled,
            boolean accountNonExpired, boolean credentialsNonExpired,
            boolean accountNonLocked,
            Collection authorities, Long id,
            String firstName, String lastName, String branchNo ,short isAdmin) {

        super(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.branchNo=branchNo;
        this.isAdmin = isAdmin;

    }

    public Long getId() {
        return id;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public short getIsAdmin() {
        return isAdmin;
    }

    public String getBranchNo() {
        return branchNo;
    }
    
    

}
