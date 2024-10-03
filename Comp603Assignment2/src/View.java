
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class View extends JFrame {

    JPanel startPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel questionPanel = new JPanel();
    JPanel userPanel = new JPanel();
    JPanel loserPanel = new JPanel();
    JPanel quitPanel = new JPanel();

    JLabel titleLabel = new JLabel("Who wants to be a millionaire?");
    JLabel question = new JLabel("Question");
    JLabel loserMessage = new JLabel("You lose");
    JLabel quitMessage = new JLabel("You quit");
    
    JButton startButton = new JButton("Click button to start the quiz");

    JButton optionA = new JButton("A");
    JButton optionB = new JButton("B");
    JButton optionC = new JButton("C");
    JButton optionD = new JButton("D");
    
    JButton quitButton = new JButton("quit game");
    JButton answerButton = new JButton("answer");
    
    JButton resetButton = new JButton("Restart");

    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        
        startPanel.setLayout(new BorderLayout());
        
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 50));
        startButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        startPanel.add(titleLabel, BorderLayout.CENTER);
        startPanel.add(startButton, BorderLayout.SOUTH);

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
    
    public void loserScreen() {
        loserPanel.setFont(new Font("SansSerif", Font.PLAIN, 60));
        loserPanel.add(loserMessage);
        
        this.getContentPane().removeAll();
        loserPanel.setVisible(true);
        this.add(loserPanel);
        this.revalidate();
        this.repaint();
    }
    
    public void quitScreen(){
        quitPanel.setLayout(new BorderLayout());
        
        quitMessage.setFont(new Font("SansSerif", Font.PLAIN, 50));
        resetButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        
        quitMessage.setHorizontalAlignment(SwingConstants.CENTER);
        
        quitPanel.add(quitMessage, BorderLayout.NORTH);
        quitPanel.add(resetButton, BorderLayout.SOUTH);
        
        
        this.getContentPane().removeAll();
        quitPanel.setVisible(true);
        this.add(quitPanel);
        this.revalidate();
        this.repaint();
    }
    
    
    public void resetPanel(){
        System.out.println("Game has been reset");
        this.getContentPane().removeAll();
        startPanel.setVisible(true);
        this.add(startPanel);
        this.revalidate();
        this.repaint();
    }
}
