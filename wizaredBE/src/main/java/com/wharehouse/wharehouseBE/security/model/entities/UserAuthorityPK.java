package com.wharehouse.wharehouseBE.security.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class UserAuthorityPK implements Serializable {

    private Long userId;
    private Long authorityId;

    public UserAuthorityPK() {
    }

    public UserAuthorityPK(Long userId, Long authorityId) {
        this.userId = userId;
        this.authorityId = authorityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public String toString() {
        return "UserAuthorityPK{" + "userId=" + userId + ", authorityId=" + authorityId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.userId);
        hash = 41 * hash + Objects.hashCode(this.authorityId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserAuthorityPK other = (UserAuthorityPK) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.authorityId, other.authorityId)) {
            return false;
        }
        return true;
    }

}
