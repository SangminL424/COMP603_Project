
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame {

    JPanel startPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    JLabel welcomeLabel = new JLabel("Welcome to the game");
    JLabel descriptionLabel = new JLabel("Click button to start the game");
    JButton startButton = new JButton("start game");

    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        startPanel.add(welcomeLabel);
        startPanel.add(descriptionLabel);
        startPanel.add(startButton);
        
        this.add(startPanel);
    }
}
