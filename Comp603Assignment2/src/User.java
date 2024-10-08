/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zwty2
 */
public class User {

    private String username;

    /**
     * @return the username
     */
    public String getUsername() {  //getter
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {  //setter
        this.username = username;
    }
}
