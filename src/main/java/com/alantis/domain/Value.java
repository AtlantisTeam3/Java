/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alantis.domain;

/**
 *
 * @author cesi
 */
public class Value {
    
    private String Value;
    private String DateTime;

    public Value(String Value, String DateTime) {
        this.Value = Value;
        this.DateTime = DateTime;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String DateTime) {
        this.DateTime = DateTime;
    }
    
}
