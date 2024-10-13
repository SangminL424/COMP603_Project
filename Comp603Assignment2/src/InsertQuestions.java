
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
public class InsertQuestions {

    Database database = new Database();

    public void insertQuestions() {
        try {
            Statement statement = database.conn.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(InsertQuestions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
