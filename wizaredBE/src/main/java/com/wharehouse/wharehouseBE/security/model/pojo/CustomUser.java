/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.model.pojo;

import com.wharehouse.wharehouseBE.model.entities.StkCabinet;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.userdetails.User;


public class CustomUser extends User {

    private static final long serialVersionUID = -3531439484732724601L;
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final short isAdmin;
    private final String branchNo;
    private final List<StkCabinet> stkAccountseList;

    public CustomUser(String username, String password, boolean enabled,
            boolean accountNonExpired, boolean credentialsNonExpired,
            boolean accountNonLocked,
            Collection authorities,Collection stkAccountseList, Long id,
            String firstName, String lastName, String branchNo ,short isAdmin) {

        super(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.branchNo=branchNo;
        this.isAdmin = isAdmin;
        this.stkAccountseList = (List<StkCabinet>) stkAccountseList;

    }

    public List<StkCabinet> getStkAccountseList() {
        return stkAccountseList;
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
