/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * @author zwty2
 */
public class TrueOrFalse extends Question {

    @Override  //using polymorphism to make getQuestion output a different string
    public void getQuestionType(int type) {
        System.out.println("True or False?:");
    }

    public void printQuestion(int index) {  //loads the questions from true or false file and prints the question
        ArrayList<String> questions = loadQuestion("./folder/true_or_false_questions.txt");

        System.out.println(questions.get(index));
        System.out.println("input t(True)/f(False): ");
    }
}
