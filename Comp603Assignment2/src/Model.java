
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

    Database database = new Database();
    UserInfo user = new UserInfo();

    public Model() {
        database.dbsetup();
    }
    
    public void setUsername(String username){
        user.setUsername(username);
    }
    
    public boolean checkUsername() {  //checks if the user exists in the database
        boolean userCheck = false;

        try {
            Statement statement = database.conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, score FROM UserInfo "
                    + "WHERE userid = '" + user.getUsername() + "'");
            if (rs.next()) {
                System.out.println("found user");
                userCheck = true;
            } else {
                System.out.println("no such user");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + user.getUsername() + "', 0)");
                userCheck = true;
            }
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
