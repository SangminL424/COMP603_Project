/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zwty2
 */
public class FileIO {

    public HashMap<String, Integer> load(String filePath) {  //loads the name and earnings from the text file into a hashmap
        HashMap<String, Integer> user = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = "";

            while ((line = reader.readLine()) != null) {  //goes through the text file line by line
                String[] parts = line.split(" ");  //splits the parts by spaces
                String username = parts[0];  //part 0 are the usernames
                int earnings = Integer.parseInt(parts[1]);  //part 1 are the earnings

                user.put(username, earnings);  //adds the username and earnings to the hashmap
            }

        } catch (IOException e) {
            System.err.println("IOException Error: " + e.getMessage());
        }

        return user;
    }

    public void save(String filePath, HashMap<String, Integer> earnings) {  //saves the hashmap to a textfile
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filePath))) {
            for (Map.Entry<String, Integer> entry : earnings.entrySet()) {  //it goes through each entry in the hashmap
                writer.println(entry.getKey() + " " + entry.getValue());  //writes each key and value to the file and seperate them by a space
            }
        } catch (IOException e) {
            System.err.println("IOException Error: " + e.getMessage());
        }
    }
    
    public void updateUserScore(String filePath, HashMap<String, Integer> users, String username, int earnings) {  //updates the users name and score in the player_earnings.txt 
        users.put(username, earnings);  //add the new username and earnings to the hashmap
        save(filePath, users);  //saves hashmap to a textfile
    }
}
