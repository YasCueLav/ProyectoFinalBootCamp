/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.client;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasmin
 */
public class AccesoDatos {
    private String conn_string;
    private String driver;
    private String user;
    private String pass;
    
     public AccesoDatos() {
        
        conn_string = "jdbc:sqlserver://LAPTOP-PA76RMSN\\SQLEXPRESS:1433;databaseName=Bootcamp";
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        user = "prueba";
        pass = "sa1234";
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getConn_string() {
        return conn_string;
    }

    public void setConn_string(String conn_string) {
        this.conn_string = conn_string;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
