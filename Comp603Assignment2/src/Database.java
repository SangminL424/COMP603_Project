
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 64224
 */
public class Database {

    Connection conn = null;

    String url = "jdbc:derby://localhost:1527/QuizGameDB";
    String dbusername = "aaa";
    String dbpassword = "aaa";

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String userInfo = "UserInfo";
            if (!checkTableExisting(userInfo)) {  //if the table doesn't exist
                statement.executeUpdate("CREATE TABLE " + userInfo + " (userid VARCHAR(12), score INT)");  //creates new userinfo table with userid and score
                System.out.println("Created table " + userInfo);
            }

            String multiChoice = "multichoicequestions";
            if (!checkTableExisting(multiChoice)) {  //if the table doesn't exist
                statement.executeUpdate("CREATE TABLE " + multiChoice + " (id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                        + " question_text VARCHAR(500) NOT NULL, answer CHAR,"
                        + " question_options VARCHAR(500) NOT NULL)");  //create new multichoicequestions table with id, question text, answer and question options
                System.out.println("Created table " + multiChoice);

                insertMultiChoice();  //insert questions into the database
            }

            String trueOrFalse = "trueorfalsequestions";
            if (!checkTableExisting(trueOrFalse)) {  //if the table doesn't exist
                statement.executeUpdate("CREATE TABLE " + trueOrFalse + " (id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                        + " question_text VARCHAR(500) NOT NULL, answer CHAR,"
                        + " question_options VARCHAR(500) NOT NULL)");  //create new trueorfalsequestions table with id, question text, answer and question options
                System.out.println("Created table " + trueOrFalse);

                insertTrueFalse();  //insert questions into the database
            }

            statement.close();

        } catch (Throwable e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    private boolean checkTableExisting(String tableName) {
        boolean flag = false;

        try {
            System.out.println("checking if " + tableName + " exists...");
            String[] types = {"TABLE"};
            DatabaseMetaData metadata = conn.getMetaData();
            ResultSet rs = metadata.getTables(null, null, tableName.toUpperCase(), types);

            if (rs.next()) {
                flag = true;
                System.out.println(tableName + " exists");
            }

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public void insertQuestion(String tableName, String question_text, char answer, String question_options) {

        String query = "INSERT INTO " + tableName + " (question_text, answer, question_options) VALUES (?, ?, ?)";
        
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, question_text);
            preparedStatement.setString(2, String.valueOf(answer));
            preparedStatement.setString(3, question_options);
            preparedStatement.executeUpdate();

            System.out.println("Questions inserted");

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertMultiChoice() {  //insert multi choice questions into the database

        insertQuestion("multichoicequestions", "What is the capital city of France?", 'C', "(A)Madrid (B)Berlin (C)Paris (D)Rome");
        insertQuestion("multichoicequestions", "Which planet is known as the Red Planet?", 'B', "(A)Earth (B)Mars (C)Venus (D)Jupiter");
        insertQuestion("multichoicequestions", "What is the largest mammal in the world?", 'A', "(A)Blue Whale (B)African Elephant (C)Great White Shark (D)Giraffe");
        insertQuestion("multichoicequestions", "Which element has the chemical symbol ''O''?", 'A', "(A)Oxygen (B)Gold (C)Iron (D)Silver");
        insertQuestion("multichoicequestions", "Who wrote the play \"Romeo and Juliet\"?", 'B', "(A)Charles Dickens (B)William Shakespeare (C)Mark Twain (D)Jane Austen");
        insertQuestion("multichoicequestions", "What is the primary language spoken in Brazil?", 'C', "(A)Spanish (B)French (C)Portuguese (D)English");
        insertQuestion("multichoicequestions", "What is the chemical formula for water?", 'B', "(a)CO2 (b)H2O (c)NaCl (d)O2");
        insertQuestion("multichoicequestions", "Who was the first president of the United States?", 'B', "(A)Abraham Lincoln (B)George Washington (C)Thomas Jefferson (D)John Adams");
        insertQuestion("multichoicequestions", "Which programming language is primarily used for Android app development?", 'C', "(A)Python (B)Swift (C)Java (D)Ruby");
        insertQuestion("multichoicequestions", "Which organ in the human body is responsible for pumping blood?", 'D', "(A)Brain (B)Lungs (C)Liver (D)Heart");
    }

    public void insertTrueFalse() {  //insert true or false questions into the database

        insertQuestion("trueorfalsequestions", "The star sign aquarius is represented by a tiger.", 'F', "True or False?");
        insertQuestion("trueorfalsequestions", "''A'' is the most common letter used in the English language.", 'F', "True or False?");
        insertQuestion("trueorfalsequestions", "ASOS stands for as seen on screen.", 'T', "True or False?");
        insertQuestion("trueorfalsequestions", "H&M stands for Hennes & Mauritz.", 'T', "True or False?");
        insertQuestion("trueorfalsequestions", "K is worth four points in scrabble.", 'T', "True or False?");
        insertQuestion("trueorfalsequestions", "In the original deck of cards, the king has a moustache.", 'F', "True or False?");
        insertQuestion("trueorfalsequestions", "When the two numbers on opposite sides of a dice are added together it always equals 7.", 'T', "True or False?");
        insertQuestion("trueorfalsequestions", "In the English language there is no word that rhymes with orange.", 'T', "True or False?");
        insertQuestion("trueorfalsequestions", "English is the most spoken language in the world.", 'F', "True or False?");
        insertQuestion("trueorfalsequestions", "The Unicorn is the national animal of Scotland.", 'T', "True or False?");
    }
}
