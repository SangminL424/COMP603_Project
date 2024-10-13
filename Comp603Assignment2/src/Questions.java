/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zwty2
 */
public abstract class Questions {
    
    Database database = new Database();

    //public abstract void getQuestionType(int type);
    public ArrayList<String> loadQuestion() {  //loads questions from the database
        ArrayList<String> questions = new ArrayList<>();
        
        try {
            Statement statement = database.conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT question FROM questions");
            
            while (rs.next()) {
                String question = rs.getString("question");
                questions.add(question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }
    
    public ArrayList<Character> loadAnswer() {  //loads answers from the database

        ArrayList<Character> answers = new ArrayList<>();
        
        try {
            Statement statement = database.conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT answer FROM questions");
            
            while (rs.next()) {
                char answer = rs.getString("answer").charAt(0);
                answers.add(answer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return answers;        
    }
    
    public ArrayList<String> loadOptions() {  //loads options from the database
        ArrayList<String> optionList = new ArrayList<>();
        
        try {
            Statement statement = database.conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT options FROM questions");
            
            while (rs.next()) {
                String options = rs.getString("options");
                optionList.add(options);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return optionList;
    }
}
