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
    FileIO fileIO = new FileIO();
    HashMap<String, Integer> users = fileIO.load("./folder/player_earnings.txt");

    Earnings earnings = new Earnings();

    public void askUsername() {  //asks the user for their name
        System.out.println("What is your name?");
        setUsername(scan.nextLine());
    }

    public void askUserQuit(int round) {  //asks the user if they would like to continue or quit
        System.out.println("Would you like to continue or quit and walk away with your earnings?");
        System.out.println("input c to continue or q to quit");
        char input = scan.nextLine().charAt(0);

        while (input != 'c' && input != 'q') {  //while the input is not c or q it will keep asking the user to input the correct input
            System.out.println("Invalid Input Please Input c or q: ");
            input = scan.nextLine().charAt(0);
        }

        if (input == 'c') {  //if the input is c the game will go on
            System.out.println("the game will continue");
        } else if (input == 'q') {  //if the input is q the game will quit
            askUsername();  //ask user for their name
            earnings.earningsPerRound(round);  //check what the player's earnings are
            System.out.println("You won $" + earnings.getEarnings());  //print how much the player earned
            fileIO.updateUserScore("./folder/player_earnings.txt", users, this.getUsername(), earnings.getEarnings());  //update the player_earnings.txt file with player's name and earnings
            System.exit(0);  //ends program
        }
    }

    public void askWinnerName(){  //asks for the winner's name
        System.out.println("You won a Million Dollars!!!");
        askUsername();  //ask user for their name
        fileIO.updateUserScore("./folder//player_earnings.txt", users, this.getUsername(), 1000000);  //update the player_earnings.txt file with player's name and earnings
        System.out.println("Congratulations!!");
        System.out.println("Thanks for playing");
        System.exit(0);  //program ends
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
