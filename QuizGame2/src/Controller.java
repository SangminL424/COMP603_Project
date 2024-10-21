
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Controller {

    View view;
    Model model;

    //constructor that initialises the view and model and adds start and quit button listeners
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        //listener for startButton
        view.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked the start button");
                model.setUsername(view.usernameField.getText());  //set the username to what the user input in the username textfield
                if (model.checkUsername()) {
                    nextQuestion();  //move to the next question if checkUsername method returns true
                }
            }
        });

        //listener for quitButton
        removeListeners(view.quitButton);
        view.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You quit the game");
                System.exit(0);  //quit the program if the quit button is pressed
            }
        });
    }

    Random rand = new Random();
    int questionType = 0;
    int max_rounds = 10;
    int current_round = 0;

    //move to the next question in the quiz
    public void nextQuestion() {
        if (current_round < max_rounds) {  //if the current round isn't bigger than the max rounds
            questionType = rand.nextInt(2);  //randomly choose a number between 0 and 1 

            switch (questionType) {
                case 0:  //if the random number is 0 it shows a multi choice question
                    System.out.println("Multi Choice Question");
                    multiChoice();
                    break;
                case 1:  //if the random number is 0 it shows a true or false question
                    System.out.println("True or False Question");
                    trueOrFalse();
                    break;
                default:
                    System.out.println("no");
                    break;
            }
        }

        if (current_round == max_rounds) {  //if current round reaches the max rounds you win the game
            winGame();
        }
    }

    char userGuess;

    //switch the screen to the multi choice question screen and set up all the listeners for the buttons
    public void multiChoice() {
        view.multiquestion.setText(model.getMultiQuestionById(current_round));  //set the question text to the question of the current round
        view.multioptions.setText(model.getMultiOptionsById(current_round));  //set the options text to the options of the current round
        view.multiChoiceScreen();  //switch to the multi choice question screen

        updateCurrentEarnings();  //update the current earnings label to the user's current earnings

        //listeners for the buttons
        removeListeners(view.optionA);
        view.optionA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option A");
                userGuess = 'A';
                checkAnswer(userGuess);  //check if the user's guess is correct
            }
        });

        removeListeners(view.optionB);
        view.optionB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option B");
                userGuess = 'B';
                checkAnswer(userGuess);  //check if the user's guess is correct
            }
        });

        removeListeners(view.optionC);
        view.optionC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option C");
                userGuess = 'C';
                checkAnswer(userGuess);  //check if the user's guess is correct
            }
        });

        removeListeners(view.optionD);
        view.optionD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option D");
                userGuess = 'D';
                checkAnswer(userGuess);  //check if the user's guess is correct
            }
        });

        removeListeners(view.stopButton);
        view.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopQuiz();  //stops the quiz if the button is pressed
            }
        });
    }

    public void trueOrFalse() {
        view.truefalsequestion.setText(model.getTrueFalseQuestionById(current_round));
        view.truefalseoptions.setText(model.getTrueFalseOptionsById(current_round));
        view.trueOrFalseScreen();

        updateCurrentEarnings();  //update the current earnings label to the user's current earnings

        removeListeners(view.trueButton);
        view.trueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option True");
                userGuess = 'T';
                checkAnswer(userGuess);  //check if the user's guess is correct
            }
        });

        removeListeners(view.falseButton);
        view.falseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option False");
                userGuess = 'F';
                checkAnswer(userGuess);  //check if the user's guess is correct
            }
        });

        removeListeners(view.stopButton);
        view.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopQuiz();  //stops the quiz if the button is pressed
            }
        });
    }
    
    //check the answer
    public void checkAnswer(char userGuess) {
        if (model.checkAnswer(current_round, userGuess)) {  //if the user's guess is correct move to the next round
            current_round++;
            nextQuestion();  
            updateCurrentEarnings();  //update the current earnings label to the user's current earnings
        } else {  //if the user's guess is incorrect user loses the game
            System.out.println("Wrong");
            loseGame();
        }
    }

    //show the user how much they have earned and give the user the option to quit the game or restart
    public void stopQuiz() {
        System.out.println("You clicked the quit button");
        view.stopMessage.setText("You Won $" + model.getCurrentEarnings(current_round) + "!!");  //change the label to how much they have earned in the quiz
        model.stopQuiz();  //store the username and score in the database
        view.stopScreen();  //change the screen to the stop screen

        //listeners for the reset and quit buttons
        removeListeners(view.resetButton);
        view.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();  //changes the screen to the start screen and resets the game rounds and score
            }
        });

        removeListeners(view.quitButton);
        view.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You quit the game");
                System.exit(0);  //quit the game
            }
        });
    }

    //change the screen to the loser screen and sets their score to 0 and give the user the option to quit the game or restart
    public void loseGame() {
        System.out.println("You Lose");

        model.wrongAnswer();  //store their username in the database with the score of 0
        view.loserScreen();  //change the screen to the loser screen

        //listeners for the reset and quit buttons
        removeListeners(view.resetButton);
        view.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();  //changes the screen to the start screen and resets the game rounds and score
            }
        });

        removeListeners(view.quitButton);
        view.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You quit the game");
                System.exit(0);  //quit the game
            }
        });
    }

    //change the screen to win screen and give the user the option to quit or restart
    public void winGame() {
        System.out.println("You Win");

        view.winScreen();  //change the screen to win screen
        model.winGame();

        //listeners for the reset and quit buttons
        removeListeners(view.resetButton);
        view.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();  //changes the screen to the start screen and resets the game rounds and score
            }
        });

        removeListeners(view.quitButton);
        view.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You quit the game");
                System.exit(0);  //quit the game
            }
        });
    }

    //changes the screen to the start screen and resets the game rounds and score
    public void resetGame() {
        current_round = 0;  //reset the current round to 0
        view.resetPanel();  //change the screen back to the start screen
        model.setCurrentEarnings(0);  //reset the current earnings to 0
        updateCurrentEarnings();  //update the current earnings label to the user's current earnings
    }
    
    //update the current earnings label to the user's current earnings
    public void updateCurrentEarnings() {
        view.currentEarnings.setText("Current Earnings: " + String.valueOf(model.getCurrentEarnings(current_round)));
    }

    //prevents the buttons from being activated more than once
    public void removeListeners(javax.swing.JButton button) {
        for (ActionListener al : button.getActionListeners()) {
            button.removeActionListener(al);
        }
    }
}
