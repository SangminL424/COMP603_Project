
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame {

    JPanel startPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel questionPanel = new JPanel();
    JPanel userPanel = new JPanel();

    JLabel welcomeLabel = new JLabel("Welcome to the game");
    JLabel descriptionLabel = new JLabel("Click button to start the game");
    JLabel question = new JLabel("Question");
    
    JButton startButton = new JButton("start game");

    JButton optionA = new JButton("A");
    JButton optionB = new JButton("B");
    JButton optionC = new JButton("C");
    JButton optionD = new JButton("D");
    
    JButton quitButton = new JButton("quit game");
    JButton answerButton = new JButton("answer");

    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);

        startPanel.add(welcomeLabel);
        startPanel.add(descriptionLabel);
        startPanel.add(startButton);

        this.add(startPanel);
    }

    public void startQuiz() {
        this.setLayout(new GridLayout(3, 1));
        
        questionPanel.add(question);
        
        buttonPanel.add(optionA);
        buttonPanel.add(optionB);
        buttonPanel.add(optionC);
        buttonPanel.add(optionD);
        
        buttonPanel.setLayout(new GridLayout(2, 2));

        userPanel.add(answerButton);
        userPanel.add(quitButton);
        
        
        
        this.getContentPane().removeAll();
        questionPanel.setVisible(true);
        buttonPanel.setVisible(true);
        userPanel.setVisible(true);
        this.add(questionPanel);
        this.add(buttonPanel);
        this.add(userPanel);
        this.revalidate();
        this.repaint();
    }
}
