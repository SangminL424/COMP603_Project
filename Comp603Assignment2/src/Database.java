
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
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
            if (!checkTableExisting(userInfo)) {
                statement.executeUpdate("CREATE TABLE " + userInfo + " (userid VARCHAR(12), score INT)");
                System.out.println("Created table " + userInfo);
            }

            String questions = "questions";
            if (!dropTableIfExists(questions)) {
                statement.executeUpdate("CREATE TABLE " + questions + " (id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, question_text VARCHAR(12) NOT NULL, answer CHAR, question_options VARCHAR(255) NOT NULL, question_type VARCHAR(50))");
                System.out.println("Created table " + questions);
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
    
    private boolean dropTableIfExists(String tableName) {
        boolean flag = false;

        try {
            System.out.println("checking if " + tableName + " exists...");
            String[] types = {"TABLE"};
            DatabaseMetaData metadata = conn.getMetaData();
            ResultSet rs = metadata.getTables(null, null, tableName.toUpperCase(), types);

            if (rs.next()) {
                flag = true;
                System.out.println(tableName + " exists");
                
                Statement statement = conn.createStatement();
                statement.executeUpdate("DROP TABLE " + tableName);
                statement.close();
                System.out.println(tableName + " dropped");
            }
            
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public void insertQuestion(String question_text, char answer, String question_options, String question_type) {
        try {
            Statement statement = conn.createStatement();

            String query = "INSERT INTO questions (question_text, answer, question_options, question_type) "
                    + "VALUES ('" + question_text + "', '" + answer + "', '" + question_options + "', '" + question_type + "')";

            statement.executeUpdate(query);

            statement.close();

            System.out.println("Questions inserted");

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertQuestions() {  //insert questions into the database
        String multichoice = "Multi-Choice";
        String trueorfalse = "True or False";
        String trueorfalseoptions = "True or False?";

        insertQuestion("What is the capital city of France?", 'C', "(A)Madrid (B)Berlin (C)Paris (D)Rome", multichoice);
        insertQuestion("Which planet is known as the Red Planet?", 'B', "(A)Earth (B)Mars (C)Venus (D)Jupiter", multichoice);
        insertQuestion("What is the largest mammal in the world?", 'A', "(A)Blue Whale (B)African Elephant (C)Great White Shark (D)Giraffe", multichoice);
        insertQuestion("Which element has the chemical symbol 'O'?", 'A', "(A)Oxygen (B)Gold (C)Iron (D)Silver", "Multi-Choice");
        insertQuestion("Who wrote the play \"Romeo and Juliet\"?", 'B', "(A)Charles Dickens (B)William Shakespeare (C)Mark Twain (D)Jane Austen", multichoice);
        insertQuestion("What is the primary language spoken in Brazil?", 'C', "(A)Spanish (B)French (C)Portuguese (D)English", multichoice);
        insertQuestion("What is the chemical formula for water?", 'B', "(a)CO2 (b)H2O (c)NaCl (d)O2", multichoice);
        insertQuestion("Who was the first president of the United States?", 'B', "(A)Abraham Lincoln (B)George Washington (C)Thomas Jefferson (D)John Adams", multichoice);
        insertQuestion("Which programming language is primarily used for Android app development?", 'C', "(A)Python (B)Swift (C)Java (D)Ruby", multichoice);
        insertQuestion("Which organ in the human body is responsible for pumping blood?", 'D', "(A)Brain (B)Lungs (C)Liver (D)Heart", multichoice);

        insertQuestion("The star sign aquarius is represented by a tiger.", 'F', trueorfalseoptions, trueorfalse);
        insertQuestion("'A' is the most common letter used in the English language.", 'F', trueorfalseoptions, trueorfalse);
        insertQuestion("ASOS stands for as seen on screen.", 'T', trueorfalseoptions, trueorfalse);
        insertQuestion("H&M stands for Hennes & Mauritz.", 'T', trueorfalseoptions, trueorfalse);
        insertQuestion("K is worth four points in scrabble.", 'T', trueorfalseoptions, trueorfalse);
        insertQuestion("In the original deck of cards, the king has a moustache.", 'F', trueorfalseoptions, trueorfalse);
        insertQuestion("When the two numbers on opposite sides of a dice are added together it always equals 7.", 'T', trueorfalseoptions, trueorfalse);
        insertQuestion("In the English language there is no word that rhymes with orange.", 'T', trueorfalseoptions, trueorfalse);
        insertQuestion("English is the most spoken language in the world.", 'F', trueorfalseoptions, trueorfalse);
        insertQuestion("The Unicorn is the national animal of Scotland.", 'T', trueorfalseoptions, trueorfalse);

    }
}
