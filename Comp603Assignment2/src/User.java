/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author zwty2
 */
public class User {

    private String username;
    Scanner scan = new Scanner(System.in);
    Database fileIO = new Database();

    Earnings earnings = new Earnings();

    public void askUsername() {  //asks the user for their name
        
    }

    public void askUserQuit(int round) {  //asks the user if they would like to continue or quit
        
    }

    public void askWinnerName(){  //asks for the winner's name
       
    }
    
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
