
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
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
        multi.loadQuestions();  //loads questions, answers and options to arraylists and are stored inside the MultiChoice class
        truefalse.loadQuestions();  //loads questions, answers and options to arraylists and are stored inside the TrueOrFalse class
    }

    public void setUsername(String username) {
        user.setUsername(username);
    }

    public boolean checkUsername() {
        boolean userCheck = false;

        try {
            // Directly check for user existence
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

    public void quitGame() {

        Statement statement;
        try {
            statement = database.conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=" + user.getScore() + " WHERE userid='" + user.getUsername() + "'");

        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
