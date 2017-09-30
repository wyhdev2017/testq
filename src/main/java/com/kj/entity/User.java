package com.kj.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wyh on 2017/9/30.
 */
@Entity
public class User {
    private String userId;
    private String password;
    private String salt;
    private String roleIds;
    private Byte locked;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "role_ids")
    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    @Basic
    @Column(name = "locked")
    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (salt != null ? !salt.equals(user.salt) : user.salt != null) return false;
        if (roleIds != null ? !roleIds.equals(user.roleIds) : user.roleIds != null) return false;
        if (locked != null ? !locked.equals(user.locked) : user.locked != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (roleIds != null ? roleIds.hashCode() : 0);
        result = 31 * result + (locked != null ? locked.hashCode() : 0);
        return result;
    }
}
