
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            String tableName = "UserInfo";

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), score INT)");
            }

            statement.close();

        } catch (Throwable e) {
            System.out.println("error");
        }
    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;

        try {
            System.out.println("check existing tables... ");
            String[] types = {"TABLE"};
            DatabaseMetaData metadata = conn.getMetaData();
            ResultSet rs = metadata.getTables(null, null, null, null);

            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + " is there");
                    flag = true;
                }
            }
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
        }
        return flag;
    }
}
