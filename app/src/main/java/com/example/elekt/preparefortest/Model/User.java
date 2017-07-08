package com.example.elekt.preparefortest.Model;

/**
 * Created by elekt on 07.07.2017.
 */

public class User {
    private String login;
    private String password;
    private Long id;
    private Boolean isBlocked;

    public User(long id, String login, String password) {
        this.login = login;
        this.password = password;
        this.id = id;
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

    public Boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Long getId() {
        return id;
    }
}
