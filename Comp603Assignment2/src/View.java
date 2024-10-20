
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
    JPanel optionsPanel = new JPanel();
    JPanel userPanel = new JPanel();
    JPanel loserPanel = new JPanel();
    JPanel quitPanel = new JPanel();
    JPanel winnerPanel = new JPanel();

    JLabel titleLabel = new JLabel("Who wants to be a millionaire?");
    JLabel multiquestion = new JLabel("Question");
    JLabel truefalsequestion = new JLabel("Question");
    JLabel multioptions = new JLabel("Options");
    JLabel truefalseoptions = new JLabel("Options");
    JLabel loserMessage = new JLabel("You lose");
    JLabel quitMessage = new JLabel("You quit");
    JLabel currentEarnings = new JLabel("Current Earnings");
    JLabel winnerMessage = new JLabel("Win");

    JLabel userName = new JLabel("Username: ");
    JTextField usernameField = new JTextField(10);

    JButton startButton = new JButton("Click button to start the quiz");
    JButton optionA = new JButton("A");
    JButton optionB = new JButton("B");
    JButton optionC = new JButton("C");
    JButton optionD = new JButton("D");
    JButton trueButton = new JButton("True");
    JButton falseButton = new JButton("False");
    JButton quitButton = new JButton("quit game");
    JButton resetButton = new JButton("Restart");

    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        startScreen();
    }

    public void startScreen() {

        startPanel.removeAll();

        startPanel.setLayout(new BorderLayout());

        titleLabel.setFont(new Font("Dialog", Font.BOLD, 50));
        startButton.setFont(new Font("Dialog", Font.BOLD, 20));

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        usernameField.setPreferredSize(new Dimension(150, 25));

        nameInputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        nameInputPanel.add(userName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        nameInputPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        nameInputPanel.add(startButton, gbc);

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(nameInputPanel, BorderLayout.NORTH);

        startPanel.add(titleLabel, BorderLayout.NORTH);

        startPanel.add(wrapperPanel, BorderLayout.CENTER);

        this.getContentPane().removeAll();
        startPanel.setVisible(true);
        this.add(startPanel);
        this.revalidate();
        this.repaint();
    }

    public void multiChoiceScreen() {
        this.setLayout(new GridLayout(4, 1));

        questionPanel.removeAll();
        optionsPanel.removeAll();
        buttonPanel.removeAll();
        userPanel.removeAll();

        multiquestion.setFont(new Font("Dialog", Font.BOLD, 20));
        questionPanel.add(multiquestion);

        multioptions.setFont(new Font("Dialog", Font.BOLD, 25));
        optionsPanel.add(multioptions);

        optionA.setFont(new Font("Dialog", Font.BOLD, 20));
        optionB.setFont(new Font("Dialog", Font.BOLD, 20));
        optionC.setFont(new Font("Dialog", Font.BOLD, 20));
        optionD.setFont(new Font("Dialog", Font.BOLD, 20));

        buttonPanel.add(optionA);
        buttonPanel.add(optionB);
        buttonPanel.add(optionC);
        buttonPanel.add(optionD);

        buttonPanel.setLayout(new GridLayout(2, 2));

        userPanel.add(currentEarnings);
        userPanel.add(quitButton);

        this.getContentPane().removeAll();
        questionPanel.setVisible(true);
        optionsPanel.setVisible(true);
        buttonPanel.setVisible(true);
        userPanel.setVisible(true);
        this.add(questionPanel);
        this.add(optionsPanel);
        this.add(buttonPanel);
        this.add(userPanel);
        this.revalidate();
        this.repaint();
    }

    public void trueOrFalseScreen() {
        this.setLayout(new GridLayout(4, 1));

        optionsPanel.removeAll();
        questionPanel.removeAll();
        buttonPanel.removeAll();
        userPanel.removeAll();

        truefalseoptions.setFont(new Font("Dialog", Font.BOLD, 20));
        optionsPanel.add(truefalseoptions);

        truefalsequestion.setFont(new Font("Dialog", Font.BOLD, 25));
        questionPanel.add(truefalsequestion);

        trueButton.setFont(new Font("Dialog", Font.BOLD, 20));
        falseButton.setFont(new Font("Dialog", Font.BOLD, 20));

        buttonPanel.add(trueButton);
        buttonPanel.add(falseButton);

        buttonPanel.setLayout(new GridLayout(1, 2));

        userPanel.add(currentEarnings);
        userPanel.add(quitButton);

        this.getContentPane().removeAll();
        optionsPanel.setVisible(true);
        questionPanel.setVisible(true);
        buttonPanel.setVisible(true);
        userPanel.setVisible(true);
        this.add(optionsPanel);
        this.add(questionPanel);
        this.add(buttonPanel);
        this.add(userPanel);
        this.revalidate();
        this.repaint();
    }

    public void loserScreen() {
        loserPanel.setLayout(new BorderLayout());

        loserMessage.setFont(new Font("Dialog", Font.BOLD, 60));
        resetButton.setFont(new Font("Dialog", Font.BOLD, 20));

        loserMessage.setHorizontalAlignment(SwingConstants.CENTER);
        loserMessage.setText("You Lose");

        loserPanel.add(loserMessage, BorderLayout.NORTH);
        loserPanel.add(resetButton, BorderLayout.SOUTH);

        this.getContentPane().removeAll();
        loserPanel.setVisible(true);
        this.add(loserPanel);
        this.revalidate();
        this.repaint();
    }

    public void quitScreen() {
        quitPanel.setLayout(new BorderLayout());

        quitMessage.setFont(new Font("Dialog", Font.BOLD, 50));
        resetButton.setFont(new Font("Dialog", Font.BOLD, 20));

        quitMessage.setHorizontalAlignment(SwingConstants.CENTER);

        quitPanel.add(quitMessage, BorderLayout.NORTH);
        quitPanel.add(resetButton, BorderLayout.SOUTH);

        this.getContentPane().removeAll();
        quitPanel.setVisible(true);
        this.add(quitPanel);
        this.revalidate();
        this.repaint();
    }

    public void winScreen() {
        winnerPanel.setLayout(new BorderLayout());

        winnerMessage.setFont(new Font("Dialog", Font.BOLD, 50));
        resetButton.setFont(new Font("Dialog", Font.BOLD, 20));

        winnerMessage.setHorizontalAlignment(SwingConstants.CENTER);
        
        winnerMessage.setText("You are now a Millionaire!!");

        winnerPanel.add(winnerMessage);
        winnerPanel.add(quitButton);
        winnerPanel.add(resetButton);

        this.getContentPane().removeAll();
        winnerPanel.setVisible(true);
        this.add(winnerPanel);
        this.revalidate();
        this.repaint();
    }

    public void resetPanel() {
        System.out.println("Game has been reset");
        this.getContentPane().removeAll();
        startScreen();

        this.revalidate();
        this.repaint();
    }
}
