
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author zwty2
 */
public class UserInfo {

    private String username;
    private int score = 0;
    
    Database database = new Database();

    

    public void earningsPerRound(int round) {  //amount of earned money goes up every round

        switch (round) {  //for every round the amount of earnings go up
            case 0:
                setScore(50);
                break;
            case 1:
                setScore(100);
                break;
            case 2:
                setScore(500);
                break;
            case 3:
                setScore(1000);
                break;
            case 4:
                setScore(5000);
                break;
            case 5:
                setScore(10000);
                break;
            case 6:
                setScore(50000);
                break;
            case 7:
                setScore(100000);
                break;
            case 8:
                setScore(500000);
                break;
            case 9:
                setScore(1000000);
                break;
        }
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

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
}
