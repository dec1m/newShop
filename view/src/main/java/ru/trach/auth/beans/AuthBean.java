package ru.trach.auth.beans;


import ru.trach.auth.ejb.AuthenticationManager;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class AuthBean implements Serializable {
    @EJB
    private AuthenticationManager authenticationManager;
    private boolean loggedIn;
    private String login;
    private String password;


    public void doLogin(){
        if (login == null || password == null) { loggedIn = false; return; }
        if (login.length() < 1 || password.length() < 1) { loggedIn =  false; return; }

        loggedIn = authenticationManager.login(login,password);


    }
    public String unLogin(){
        loggedIn = false;
        return "login.xhtml";
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
