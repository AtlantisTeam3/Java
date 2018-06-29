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
public class Device implements Serializable { 

    public Device() {
    }
    
    private String id;
    
    private String Device_mac;
    private String Device_name;
    private String user;
    private String DateTimeFirst;
    private String type;
    private Value value;

    public Value getValues() {
        return value;
    }

    public Device(String Device_mac, String Device_name, String user, String DateTimeFirst, String type, Value value, String DateTime) {
        this.Device_mac = Device_mac;
        this.Device_name = Device_name;
        this.user = user;
        this.DateTimeFirst = DateTimeFirst;
        this.type = type;
        this.value = value;
    }

    public void setValues(Value values) {
        this.value = values;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDevice_mac() {
        return Device_mac;
    }

    public void setDevice_mac(String Device_mac) {
        this.Device_mac = Device_mac;
    }

    public String getDevice_name() {
        return Device_name;
    }

    public void setDevice_name(String Device_name) {
        this.Device_name = Device_name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDateTimeFirst() {
        return DateTimeFirst;
    }

    public void setDateTimeFirst(String DateTimeFirst) {
        this.DateTimeFirst = DateTimeFirst;
    }
    
}
