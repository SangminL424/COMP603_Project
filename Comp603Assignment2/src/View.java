
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View extends JFrame {
    
    JPanel startPanel = new JPanel();
    JPanel nameInputPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel questionPanel = new JPanel();
    JPanel userPanel = new JPanel();
    JPanel loserPanel = new JPanel();
    JPanel quitPanel = new JPanel();

    JLabel titleLabel = new JLabel("Who wants to be a millionaire?");
    JLabel question = new JLabel("Question");
    JLabel loserMessage = new JLabel("You lose");
    JLabel quitMessage = new JLabel("You quit");

    JLabel userName = new JLabel("Username: ");
    JTextField inputUsername = new JTextField(10);

    JButton startButton = new JButton("Click button to start the quiz");

    JButton optionA = new JButton("A");
    JButton optionB = new JButton("B");
    JButton optionC = new JButton("C");
    JButton optionD = new JButton("D");

    JButton trueButton = new JButton("True");
    JButton falseButton = new JButton("False");

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

        inputUsername.setPreferredSize(new Dimension(150, 25));
        nameInputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 0.0;
        nameInputPanel.add(userName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.0;
        nameInputPanel.add(inputUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        nameInputPanel.add(startButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        startPanel.add(titleLabel, BorderLayout.NORTH);
        startPanel.add(nameInputPanel, BorderLayout.CENTER);

        this.add(startPanel);
    }

    public void multiChoiceScreen() {
        this.setLayout(new GridLayout(3, 1));

        questionPanel.removeAll();
        buttonPanel.removeAll();
        userPanel.removeAll();
        
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

    public void trueOrFalseScreen() {
        this.setLayout(new GridLayout(3, 1));

        questionPanel.removeAll();
        buttonPanel.removeAll();
        userPanel.removeAll();

        questionPanel.add(question);

        buttonPanel.add(trueButton);
        buttonPanel.add(falseButton);

        buttonPanel.setLayout(new GridLayout(1, 2));

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

    public void quitScreen() {
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

    public void resetPanel() {
        System.out.println("Game has been reset");
        this.getContentPane().removeAll();
        startPanel.setVisible(true);
        this.add(startPanel);
        this.revalidate();
        this.repaint();
    }
}
