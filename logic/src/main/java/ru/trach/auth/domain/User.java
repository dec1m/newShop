package ru.trach.auth.domain;

import ru.trach.domain.BookEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@NamedQueries({
        @NamedQuery(name= User.REMOVE, query = "DELETE FROM User u WHERE u.email = :email"),
        @NamedQuery(name= User.FIND_ALL, query = "SELECT u FROM User u"),
        @NamedQuery(name= User.GET_BY_EMAIL, query = "SELECT u FROM User u WHERE u.email = :email"),
        @NamedQuery(name= User.GET_IMG_BY_EMAIL, query = "SELECT u.avatar FROM User u WHERE u.email = :email")
})
public class User {


    @Id
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


    public static final String FIND_ALL = "USER_FIND_ALL";
    public static final String REMOVE = "USER_REMOVE";
    public static final String GET_BY_EMAIL = "USER_GET_BY_EMAIL";
    public static final String GET_IMG_BY_EMAIL = "USER_GET_IMG_BY_EMAIL";


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
