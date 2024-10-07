/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.Random;

/**
 *
 * @author zwty2
 */
public class QuizGame {

    public static void main(String[] args) {
        Random rand = new Random();
        int type;
        int rounds = 10;
        
        QuizGenerator quizgen = new QuizGenerator();
        Earnings earnings = new Earnings();
        User user = new User();
         DatabaseHelper db = new DatabaseHelper();
         
         db.createTables(); // initializing data base tables
        
        try {
            for (int i = 0; i < rounds; i++) {  //there are 10 rounds
                type = rand.nextInt(2);  //picks 0 or 1 randomly
                quizgen.handleTypes(type, i);  //generates the question by type and round
                System.out.println();
                
                if (i == 9) {  //if the user gets to the final round
                    user.askWinnerName();  //asks for the user's name
                }
                
                earnings.printCurrentEarnings(i);  //prints the current earnings of the user
                System.out.println();

                user.askUserQuit(i);  //asks the user if they want to continue or quit
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("You Left");
        }
    }
}
