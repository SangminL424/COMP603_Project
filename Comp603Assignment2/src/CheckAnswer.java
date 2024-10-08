/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * @author zwty2
 */
public class CheckAnswer {

    UserInfo user = new UserInfo();

    public void checkMultiChoiceAnswer(int index, char input) {  //checks answers for multichoice questions
        MultiChoice multi = new MultiChoice();
        ArrayList<Character> answers = multi.loadAnswer("./folder/multichoice_questions.txt");

        //checks if the user input is equal to the answer
        if (answers.get(index) == input) { //if correct
            System.out.println("Correct!");
        } else {  //if not correct the program will end
            System.out.println("Game Over");
            System.out.println("You Win Nothing");
            System.exit(0);
        }
    }

    public void checkTrueOrFalseAnswer(int index, char input) {  //checks answers for true or false questions
        TrueOrFalse truefalse = new TrueOrFalse();
        ArrayList<Character> answers = truefalse.loadAnswer("./folder/true_or_false_questions.txt");

        //checks if the user input is equal to the answer
        if (answers.get(index) == input) {
            System.out.println("Correct!");
        } else {  //if not correct the program will end
            System.out.println("Game Over");
            System.out.println("You Win Nothing");
            System.exit(0);
        }
    }
}
