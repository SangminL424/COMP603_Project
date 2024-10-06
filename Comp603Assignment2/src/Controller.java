
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Controller {

    View view = new View();

    public Controller(View view) {
        this.view = view;

        view.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked the start button");
                startQuiz();
            }
        });
    }

    public void startQuiz(){
        Random rand = new Random();
        
        int quizType = rand.nextInt(2);
        
        switch (quizType) {
            case 0:
                System.out.println("Multi Choice Question");
                view.multiChoiceScreen();
                multiChoice();
                break;
            case 1:
                System.out.println("True or False Question");
                view.trueOrFalseScreen();
                trueOrFalse();
                break;
            default:
                System.out.println("no");
                break;
        }
    }
    
    public void multiChoice() {
        
        removeListeners(view.optionA);
        view.optionA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option A");
            }
        });

        removeListeners(view.optionB);
        view.optionB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option B");
            }
        });

        removeListeners(view.optionC);
        view.optionC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option C");
            }
        });

        removeListeners(view.optionD);
        view.optionD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option D");
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
            }
        });
        
        removeListeners(view.falseButton);
        view.falseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option False");
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
