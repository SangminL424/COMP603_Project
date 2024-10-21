
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {

    Connection conn = null;

    //database connection details
    String url = "jdbc:derby://localhost:1527/QuizGameDB;create=true";
    String dbusername = "aaa";
    String dbpassword = "aaa";

    //setup database
    public void dbsetup() {
        try {

            //automatically connect to the database without manually connecting
            conn = automaticDBConnection();

            Statement statement = conn.createStatement();

            //check if userinfo table already exists
            //if it doesn't exist, create a new table userinfo with userid and score
            String userInfo = "UserInfo";
            if (!checkTableExisting(userInfo)) {  //if the table doesn't exist
                statement.executeUpdate("CREATE TABLE " + userInfo + " (userid VARCHAR(12), score INT)");  //creates new userinfo table with userid and score
                System.out.println("Created table " + userInfo);
            }

            //check if multichoicequestions table already exists
            //if it doesn't exist, create a new table multichoicequestions with id, question_text, answers and question_options
            String multiChoice = "multichoicequestions";
            if (!checkTableExisting(multiChoice)) {  //if the table doesn't exist
                statement.executeUpdate("CREATE TABLE " + multiChoice + " (id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                        + " question_text VARCHAR(500) NOT NULL, answer CHAR,"
                        + " question_options VARCHAR(500) NOT NULL)");  //create new multichoicequestions table with id, question text, answer and question options
                System.out.println("Created table " + multiChoice);

                insertMultiChoice();  //insert multichoice questions into the database if the table didn't already exist
            }

            //check if trueorfalsequestions table already exists
            //if it doesn't exist, create a new table trueorfalsequestions with id, question_text, answers and question_options
            String trueOrFalse = "trueorfalsequestions";
            if (!checkTableExisting(trueOrFalse)) {  //if the table doesn't exist
                statement.executeUpdate("CREATE TABLE " + trueOrFalse + " (id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                        + " question_text VARCHAR(500) NOT NULL, answer CHAR,"
                        + " question_options VARCHAR(500) NOT NULL)");  //create new trueorfalsequestions table with id, question text, answer and question options
                System.out.println("Created table " + trueOrFalse);

                insertTrueFalse();  //insert true or false questions into the database if the table didn't already exist
            }

            statement.close();

        } catch (Throwable e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    //connects to the derby database automatically
    public Connection automaticDBConnection() {
        Connection conn = null;

        //starts the derby database server
        DatabaseServer.startDerbyServer();

        try {
            //load the derby client driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //create a connection to the database using the database connection details
            conn = DriverManager.getConnection(url, dbusername, dbpassword);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

    //check if a specific table already exists
    private boolean checkTableExisting(String tableName) {
        boolean flag = false;

        try {
            System.out.println("checking if " + tableName + " exists...");
            String[] types = {"TABLE"};
            DatabaseMetaData metadata = conn.getMetaData();
            ResultSet rs = metadata.getTables(null, null, tableName.toUpperCase(), types);

            if (rs.next()) {
                flag = true; //set boolean flag to true if the table already exists
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

    //inserts a question into a specified table
    public void insertQuestion(String tableName, String question_text, char answer, String question_options) {

        String query = "INSERT INTO " + tableName + " (question_text, answer, question_options) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, question_text);
            preparedStatement.setString(2, String.valueOf(answer));
            preparedStatement.setString(3, question_options);

            preparedStatement.executeUpdate();  //executes the query

            System.out.println("Question inserted");

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //insert multi choice questions into the database
    public void insertMultiChoice() {

        insertQuestion("multichoicequestions", "What is the capital city of France?", 'C', "(A)Madrid (B)Berlin (C)Paris (D)Rome");
        insertQuestion("multichoicequestions", "Which planet is known as the Red Planet?", 'B', "(A)Earth (B)Mars (C)Venus (D)Jupiter");
        insertQuestion("multichoicequestions", "What is the largest mammal in the world?", 'A', "(A)Blue Whale (B)African Elephant (C)Great White Shark (D)Giraffe");
        insertQuestion("multichoicequestions", "Which element has the chemical symbol ''O''?", 'A', "(A)Oxygen (B)Gold (C)Iron (D)Silver");
        insertQuestion("multichoicequestions", "Who wrote the play \"Romeo and Juliet\"?", 'B', "(A)Charles Dickens (B)William Shakespeare (C)Mark Twain (D)Jane Austen");
        insertQuestion("multichoicequestions", "What is the primary language spoken in Brazil?", 'C', "(A)Spanish (B)French (C)Portuguese (D)English");
        insertQuestion("multichoicequestions", "What is the chemical formula for water?", 'B', "(A)CO2 (B)H2O (C)NaCl (D)O2");
        insertQuestion("multichoicequestions", "Who was the first president of the United States?", 'B', "(A)Abraham Lincoln (B)George Washington (C)Thomas Jefferson (D)John Adams");
        insertQuestion("multichoicequestions", "Which programming language is primarily used for Android app development?", 'C', "(A)Python (B)Swift (C)Java (D)Ruby");
        insertQuestion("multichoicequestions", "Which organ in the human body is responsible for pumping blood?", 'D', "(A)Brain (B)Lungs (C)Liver (D)Heart");
    }

    //insert true or false questions into the database
    public void insertTrueFalse() {

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
