/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alantis.domain;

import java.io.Serializable;

/**
 *
 * @author cesi
 */
public class User implements Serializable {

    public User() {
    }

    private String Email;
    private String password;    
    private String id_user;
    private String name;

    public User(String id_user, String name, String password,String Email) {
        this.id_user = id_user;
        this.name = name;
        this.password = password;
        this.Email=Email;
        
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
}
