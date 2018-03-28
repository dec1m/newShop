package ru.trach.beans;

import ru.trach.auth.domain.Role;
import ru.trach.ejb.UserManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Named
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserManagerBean userManagerBean;

    @NotNull
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;
    @NotNull
    private String password;
    @NotNull
    private byte[] avatar;
    @NotNull
    private String name;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
