/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * @author zwty2
 */
public class MultiChoice extends Question{
    
    @Override
    public void getQuestionType(int type) {  //using polymorphism to make getQuestion output a different string
        System.out.println("This is a Multi Choice Question: ");
    }
    
    public void printQuestion(int index){  //loads the question from the multichoice questions file into an arraylist and prints the question
        ArrayList<String> questions = loadQuestion("./folder/multichoice_questions.txt");
        
        System.out.println(questions.get(index));
    }
    
    public void printOptions(int index){  //loads the options from the multichoice questions file into an arraylist and prints the options
        ArrayList<String> options = loadOptions("./folder/multichoice_questions.txt");
        
        System.out.println(options.get(index));
    }
}
