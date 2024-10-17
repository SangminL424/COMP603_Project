
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Controller {
    
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        view.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked the start button");
                model.setUsername(view.inputUsername.getText());
                if (model.checkUsername()) {
                    nextQuestion();
                }
            }
        });
    }

    
    Random rand = new Random();
        int questionType = 0;
        int max_rounds = 10;
        int current_round = 0;
    
    public void nextQuestion() {
        
        if(current_round < max_rounds){
            questionType = rand.nextInt(2);
            
            switch (questionType) {
                case 0:
                    System.out.println("Multi Choice Question");
                    view.multiquestion.setText(model.getMultiQuestionById(current_round));
                    view.multioptions.setText(model.getMultiOptionsById(current_round));
                    view.multiChoiceScreen();
                    multiChoice();
                    break;
                case 1:
                    System.out.println("True or False Question");
                    view.truefalsequestion.setText(model.getTrueFalseQuestionById(current_round));
                    view.truefalseoptions.setText(model.getTrueFalseOptionsById(current_round));
                    view.trueOrFalseScreen();
                    trueOrFalse();
                    break;
                default:
                    System.out.println("no");
                    break;
            }
        }
        
        if(current_round == 10){
                System.out.println("You win");
        }
    }

    char userGuess;
    
    public void multiChoice() {
        removeListeners(view.optionA);
        view.optionA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option A");
                userGuess = 'A';
                if(model.checkAnswer(current_round, userGuess)){
                    current_round++;
                    nextQuestion();
                } else {
                    model.wrongAnswer();
                    System.out.println("wrong");
                }
            }
        });

        removeListeners(view.optionB);
        view.optionB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option B");
                userGuess = 'B';
                if(model.checkAnswer(current_round, userGuess)){
                    current_round++;
                    nextQuestion();
                } else {
                    model.wrongAnswer();
                    System.out.println("wrong");
                }
            }
        });

        removeListeners(view.optionC);
        view.optionC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option C");
                userGuess = 'C';
                if(model.checkAnswer(current_round, userGuess)){
                    current_round++;
                    nextQuestion();
                } else {
                    model.wrongAnswer();
                    System.out.println("wrong");
                }
            }
        });

        removeListeners(view.optionD);
        view.optionD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option D");
                userGuess = 'D';
                if(model.checkAnswer(current_round, userGuess)){
                    current_round++;
                    nextQuestion();
                } else {
                    model.wrongAnswer();
                    System.out.println("wrong");
                }
            }
        });

        removeListeners(view.quitButton);
        view.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitGame();
            }
        });
    }

    public void trueOrFalse() {
        removeListeners(view.trueButton);
        view.trueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option True");
                userGuess = 'T';
                if(model.checkAnswer(current_round, userGuess)){
                    current_round++;
                    nextQuestion();
                } else {
                    model.wrongAnswer();
                    System.out.println("wrong");
                }
            }
        });

        removeListeners(view.falseButton);
        view.falseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option False");
                userGuess = 'F';
                if(model.checkAnswer(current_round, userGuess)){
                    current_round++;
                    nextQuestion();
                } else {
                    model.wrongAnswer();
                    System.out.println("wrong");
                }
            }
        });

        removeListeners(view.quitButton);
        view.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.quitGame();
                quitGame();
            }
        });
    }

    public void quitGame() {
        System.out.println("You clicked the quit button");

        view.quitScreen();

        removeListeners(view.resetButton);
        view.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.resetPanel();
            }
        });
    }

    //prevents the buttons from being activated more than once
    public void removeListeners(javax.swing.JButton button) {
        for (ActionListener al : button.getActionListeners()) {
            button.removeActionListener(al);
        }
    }
}
