/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wharehouse.wharehouseBE.model.entities.CrudBaseEntity;
import com.wharehouse.wharehouseBE.security.enums.AuthorityNameEnum;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

//https://github.com/szerhusenBC/jwt-spring-security-demo/blob/master/src/main/java/org/zerhusen/security/controller/MethodProtectedRestController.java
@Entity
@Table(name = "AUTHORITY")
public class Authority extends CrudBaseEntity implements Serializable {

    @Basic(optional = false)
    @Column(name = "NAME", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityNameEnum name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Users> users;

    public AuthorityNameEnum getName() {
        return name;
    }

    public void setName(AuthorityNameEnum name) {
        this.name = name;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

}
