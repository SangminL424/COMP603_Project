
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    View view = new View();

    public Controller(View view) {
        this.view = view;

        view.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked the start button");
                view.startQuiz();
                startQuiz();
            }
        });
    }

    public void startQuiz() {
        view.optionA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option A");
            }
        });

        view.optionB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option B");
            }
        });

        view.optionC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option C");
            }
        });

        view.optionD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked option D");
            }
        });

        view.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.quitScreen();
            }
        });
    }
}
