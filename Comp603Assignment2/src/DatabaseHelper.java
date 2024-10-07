

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kaan2
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private Connection connect() throws ClassNotFoundException {
        String url = "jdbc:sqlite:MillionairGame.db";
        Connection conn = null;
        try { 
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established."); 
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: "+ e.getMessage());
        }
        return conn;
    }
   
    public void createTables() {
        String sqlCreateUserTable = "CREATE TABLE IF NOT EXISTS users(\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT, \n"
                + " username TEXT NOT NULL,\n"
                + " earnings INTEGER\n"
                + ");";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCreateUserTable);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertUser(String username, int earnings) {
        String sql = "INSERT INTO users(username, earnings) VALUES(?, ?)";
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setInt(2, earnings);
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *
     * @param username
     */
    public void getUserInfo(String username) {
        String sql = "SELECT id, username, earnings FROM users WHERE username = ?";
        
        try(Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                System.out.println(rs.getInt("id")+ "\t" +
                        rs.getString("username") + "\t" +
                        rs.getInt("earnings"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
