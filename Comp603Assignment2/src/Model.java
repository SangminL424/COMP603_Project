
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
public class Model {

    UserInfo user = new UserInfo();
    Database database = new Database();
    MultiChoice multi = new MultiChoice(database);
    TrueOrFalse truefalse = new TrueOrFalse(database);

    Model() {
        database.dbsetup();
        multi.loadQuestions();
        truefalse.loadQuestions();
    }

    public boolean checkUsername() {
        boolean userCheck = false;

        try {
            //check if user exists directly from the database
            Statement statement = database.conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, score FROM UserInfo "
                    + "WHERE userid = '" + user.getUsername() + "'");

            if (rs.next()) {
                System.out.println("Found user: " + user.getUsername());
                userCheck = true;
            } else {
                System.out.println("No such user, inserting new user: " + user.getUsername());
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + user.getUsername() + "', 0)");
                userCheck = true;
            }

            if (rs != null) {
                rs.close();
            }
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userCheck;
    }

    public void setUsername(String username) {
        user.setUsername(username);
    }
    
    
    
    public void quitGame() {

        Statement statement;
        try {
            statement = database.conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=" + user.getScore() + " WHERE userid='" + user.getUsername() + "'");

        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public String getMultiQuestionById(int id) {
        return multi.getQuestions().get(id);
    }

    public String getMultiOptionsById(int id) {
        return multi.getOptions().get(id);
    }

    public char getMultiAnswerById(int id) {
        return multi.getAnswers().get(id);
    }
    
    public String getTrueFalseQuestionById(int id) {
        return truefalse.getQuestions().get(id);
    }

    public String getTrueFalseOptionsById(int id) {
        return truefalse.getOptions().get(id);
    }

    public char getTrueFalseAnswerById(int id) {
        return truefalse.getAnswers().get(id);
    }
    
    public int getCurrentEarnings(int round){
        return user.getScore();
    }
    
    public void setCurrentEarnings(int earning){
        user.setScore(earning);
    }
    
    
    public boolean checkAnswer(int id, char userGuess){
        boolean isCorrect = false;
        
        if(userGuess == getMultiAnswerById(id)){
            isCorrect = true;
            user.earningsPerRound(id);
            System.out.println(user.getScore());
        }
        if(userGuess == getTrueFalseAnswerById(id)){
            isCorrect = true;
            user.earningsPerRound(id);
            System.out.println(user.getScore());
        }
        
        return isCorrect;
    }
    
    public void wrongAnswer(){ //if the user gets the question wrong it will set their score to 0
        
        Statement statement;
        try {
            statement = database.conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=0 WHERE userid='" + user.getUsername() + "'");

        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
