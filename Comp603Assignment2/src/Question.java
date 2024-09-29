/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author zwty2
 */
public abstract class Question {

    public abstract void getQuestionType(int type);

    public ArrayList<String> loadQuestion(String filePath) {  //loads questions from the text file to an arraylist
        ArrayList<String> questions = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = "";

            while ((line = reader.readLine()) != null) {  //goes through the text file line by line
                String[] parts = line.split("=");  //splits the parts by equal signs
                String question = parts[0];  //part 0 are the questions

                questions.add(question);  //adds part 0 to the questions arraylist
            }

        } catch (IOException e) {
            System.err.println("IOException Error: " + e.getMessage());
        }

        return questions;
    }

    public ArrayList<Character> loadAnswer(String filePath) {  //loads answers from the text file to an arraylist

        ArrayList<Character> answers = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));  
            String line = "";

            while ((line = reader.readLine()) != null) {  //goes through the text file line by line
                String[] parts = line.split("=");  //splits the parts by equal signs
                char answer = parts[1].charAt(0);  //part 1 are the answers

                answers.add(answer);  //adds part 1 to the answers arraylist
            }

        } catch (IOException e) {
            System.err.println("IOException Error: " + e.getMessage());
        }

        return answers;  
    }

    public ArrayList<String> loadOptions(String filePath) {  //loads options from the text file to an arraylist
        ArrayList<String> options = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = "";

            while ((line = reader.readLine()) != null) {  //goes through the text file line by line
                String[] parts = line.split("=");  //splits the parts by equal signs
                String option = parts[2];  //part 2 are the answers

                options.add(option);  //adds part 2 to the options arraylist
            }

        } catch (IOException e) {
            System.err.println("IOException Error: " + e.getMessage());
        }

        return options;
    }
}
