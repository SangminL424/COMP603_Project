/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author zwty2
 */
public class QuizGenerator {

    Scanner scan = new Scanner(System.in);

    public void handleTypes(int type, int rounds) {  //prints different questions depending on the type
        if (type == 0) {  //if the type is 0

            //prints the options for the multichoice question
            char input = scan.nextLine().charAt(0);

            //checks for valid answers
            while (input != 'a' && input != 'b' && input != 'c' && input != 'd') {  //if the input is not a b c or d it will keep asking the user to input correctly
                System.out.println("Invalid Input");
                System.out.println("Please input a, b, c or d: ");
                input = scan.nextLine().charAt(0);
            }

            
        }
        if (type == 1) {
            char input = scan.nextLine().charAt(0);

            //checks for valid answers
            while (input != 't' && input != 'f') {  //if the input is not t or f it will keep asking the user to input correctly
                System.out.println("Invalid Input");
                System.out.println("Please input t or f: ");
                input = scan.nextLine().charAt(0);
            }

            
        }
    }
}
