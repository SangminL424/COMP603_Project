
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Model {

    UserInfo user = new UserInfo();
    Database database = new Database();
    MultiChoice multi = new MultiChoice(database);
    TrueOrFalse truefalse = new TrueOrFalse(database);
    
    Model() {
        database.dbsetup();  //set up the database connection
        multi.loadQuestions();  //load the multichoice questions from the database
        truefalse.loadQuestions();  //load the true or false questions from the database
    }

    //check if the username exists in the database
    public boolean checkUsername() {
        boolean userCheck = false;

        try {
            Statement statement = database.conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, score FROM UserInfo "
                    + "WHERE userid = '" + user.getUsername() + "'");
            if (rs.next()) {  //if the user exists return true
                System.out.println("Found user: " + user.getUsername());
                userCheck = true;
            } else {  //if the user doesn't exist, insert the new user into the database
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

    //method set the username
    public void setUsername(String username) {
        user.setUsername(username);
    }

    //methods to get the multiple choice questions, options and answers from the MultiChoice class
    public String getMultiQuestionById(int id) {
        return multi.getQuestions().get(id);
    }

    public String getMultiOptionsById(int id) {
        return multi.getOptions().get(id);
    }

    public char getMultiAnswerById(int id) {
        return multi.getAnswers().get(id);
    }
    
    
    //methods to get the true or false questions, options and answers from the TrueOrFalse class
    public String getTrueFalseQuestionById(int id) {
        return truefalse.getQuestions().get(id);
    }

    public String getTrueFalseOptionsById(int id) {
        return truefalse.getOptions().get(id);
    }

    public char getTrueFalseAnswerById(int id) {
        return truefalse.getAnswers().get(id);
    }
    
    
    //methods to get and set the current earnings of the UserInfo class
    public int getCurrentEarnings(int round){
        return user.getScore();
    }
    
    public void setCurrentEarnings(int earning){
        user.setScore(earning);
    }
    
    //check if the answer 
    public boolean checkAnswer(int id, char userGuess){
        boolean isCorrect = false;
        
        if(userGuess == getMultiAnswerById(id)){  //check the answer for multi choice question
            isCorrect = true;  //return true if the answer is correct
            user.earningsPerRound(id);  //the current earnings of the user goes up by certain amounts by round
            System.out.println(user.getScore());
        }
        if(userGuess == getTrueFalseAnswerById(id)){  //check the answer for true or false question
            isCorrect = true;  //return true if the answer is correct
            user.earningsPerRound(id);  //the current earnings of the user goes up by certain amounts by round
            System.out.println(user.getScore());
        }
        
        return isCorrect;
    }
    
    //set the user's score to 0 on the database
    public void wrongAnswer(){
        
        Statement statement;
        try {
            statement = database.conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=0 WHERE userid='" + user.getUsername() + "'");  //set the score of the user to 0

        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //store user's username and score to the database if the user stops the quiz
    public void stopQuiz() {

        Statement statement;
        try {
            statement = database.conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=" + user.getScore() + " WHERE userid='" + user.getUsername() + "'");  //store user's username and score to the database

        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //store user's username and score to the database if the user wins the game
    public void winGame() {

        Statement statement;
        try {
            statement = database.conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=" + user.getScore() + " WHERE userid='" + user.getUsername() + "'");  //store user's username and score to the database

        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
