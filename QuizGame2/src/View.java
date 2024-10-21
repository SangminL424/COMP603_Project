
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

    //panels used to organize different sections of the GUI
    JPanel startPanel = new JPanel();
    JPanel nameInputPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel questionPanel = new JPanel();
    JPanel optionsPanel = new JPanel();
    JPanel userPanel = new JPanel();
    JPanel loserPanel = new JPanel();
    JPanel stopPanel = new JPanel();
    JPanel winnerPanel = new JPanel();

    //labels for various sections of the game
    JLabel titleLabel = new JLabel("Who wants to be a millionaire?");
    JLabel multiquestion = new JLabel("Question");
    JLabel truefalsequestion = new JLabel("Question");
    JLabel multioptions = new JLabel("Options");
    JLabel truefalseoptions = new JLabel("Options");
    JLabel loserMessage = new JLabel("You lose");
    JLabel stopMessage = new JLabel("You quit");
    JLabel currentEarnings = new JLabel("Current Earnings");
    JLabel winnerMessage = new JLabel("Win");

    //label and text field for entering the username
    JLabel userName = new JLabel("Username: ");
    JTextField usernameField = new JTextField(10);

    //buttons for various actions
    JButton startButton = new JButton("Click this button to start the quiz");
    JButton optionA = new JButton("A");
    JButton optionB = new JButton("B");
    JButton optionC = new JButton("C");
    JButton optionD = new JButton("D");
    JButton trueButton = new JButton("True");
    JButton falseButton = new JButton("False");
    JButton stopButton = new JButton("Stop quiz");
    JButton quitButton = new JButton("Quit game");
    JButton resetButton = new JButton("Restart");

    //constructor that sets up the main window
    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1800, 1000);  // Set window size
        this.setResizable(false);  // Prevent resizing
        this.setLocationRelativeTo(null);  // Center the window on screen
        startScreen();  // Show the start screen when the window opens
    }

    //method to show the start screen, where the user can input their name and start the game
    public void startScreen() {

        startPanel.removeAll();  //clear the panel for fresh content

        startPanel.setLayout(new BorderLayout());  //use BorderLayout for positioning

        //set up fonts and alignments for the title and buttons
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 50));
        startButton.setFont(new Font("Dialog", Font.BOLD, 20));
        quitButton.setFont(new Font("Dialog", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);  //center the title label

        //configure the username field size
        usernameField.setPreferredSize(new Dimension(150, 25));

        //set up the name input panel with a GridBagLayout for flexibility
        nameInputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  //add padding between components

        //add username label and text field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        nameInputPanel.add(userName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        nameInputPanel.add(usernameField, gbc);

        //add start button
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        nameInputPanel.add(startButton, gbc);

        //add quit button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        nameInputPanel.add(quitButton, gbc);

        //wrap the input panel and set it up
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(nameInputPanel, BorderLayout.NORTH);

        //add the title label and input panel to the start panel
        startPanel.add(titleLabel, BorderLayout.NORTH);
        startPanel.add(wrapperPanel, BorderLayout.CENTER);

        //show the start panel
        this.getContentPane().removeAll();  //clear existing content
        startPanel.setVisible(true);  //make the start panel visible
        this.add(startPanel);  //add the panel to the JFrame
        this.revalidate();
        this.repaint();
    }

    //method to show the multiple-choice question screen
    public void multiChoiceScreen() {
        this.setLayout(new GridLayout(4, 1));  //set up layout for 4 rows

        //clear previous content
        questionPanel.removeAll();
        optionsPanel.removeAll();
        buttonPanel.removeAll();
        userPanel.removeAll();

        //configure the question label
        multiquestion.setFont(new Font("Dialog", Font.BOLD, 40));
        questionPanel.add(multiquestion);  //add question to panel

        //configure options label
        multioptions.setFont(new Font("Dialog", Font.BOLD, 25));
        optionsPanel.add(multioptions);  //add options to panel

        //set up the option buttons
        optionA.setFont(new Font("Dialog", Font.BOLD, 20));
        optionB.setFont(new Font("Dialog", Font.BOLD, 20));
        optionC.setFont(new Font("Dialog", Font.BOLD, 20));
        optionD.setFont(new Font("Dialog", Font.BOLD, 20));

        buttonPanel.add(optionA);
        buttonPanel.add(optionB);
        buttonPanel.add(optionC);
        buttonPanel.add(optionD);
        buttonPanel.setLayout(new GridLayout(2, 2));  //arrange buttons in a grid

        //add earnings display and stop button to user panel
        userPanel.add(currentEarnings);
        userPanel.add(stopButton);

        //update the JFrame content with new panels
        this.getContentPane().removeAll();
        this.add(questionPanel);
        this.add(optionsPanel);
        this.add(buttonPanel);
        this.add(userPanel);
        this.revalidate();
        this.repaint();
    }

    //method to show the True/False question screen
    public void trueOrFalseScreen() {
        this.setLayout(new GridLayout(4, 1));  //layout for 4 rows

        //clear previous content
        optionsPanel.removeAll();
        questionPanel.removeAll();
        buttonPanel.removeAll();
        userPanel.removeAll();

        //configure the options label and question label
        truefalseoptions.setFont(new Font("Dialog", Font.BOLD, 40));
        optionsPanel.add(truefalseoptions);

        truefalsequestion.setFont(new Font("Dialog", Font.BOLD, 25));
        questionPanel.add(truefalsequestion);

        //set up true or false buttons
        trueButton.setFont(new Font("Dialog", Font.BOLD, 20));
        falseButton.setFont(new Font("Dialog", Font.BOLD, 20));

        buttonPanel.add(trueButton);
        buttonPanel.add(falseButton);
        buttonPanel.setLayout(new GridLayout(1, 2));  //layout with two buttons in a row

        //add earnings display and stop button to user panel
        userPanel.add(currentEarnings);
        userPanel.add(stopButton);

        //update JFrame content with new panels
        this.getContentPane().removeAll();
        this.add(optionsPanel);
        this.add(questionPanel);
        this.add(buttonPanel);
        this.add(userPanel);
        this.revalidate();
        this.repaint();
    }

    //method to show the loser screen when the player loses
    public void loserScreen() {
        loserPanel.removeAll();
        loserPanel.setLayout(new BorderLayout());

        //configure message and buttons
        loserMessage.setFont(new Font("Dialog", Font.BOLD, 50));
        resetButton.setFont(new Font("Dialog", Font.BOLD, 20));
        quitButton.setFont(new Font("Dialog", Font.BOLD, 20));
        loserMessage.setHorizontalAlignment(SwingConstants.CENTER);
        loserMessage.setText("You Lose");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.add(resetButton);
        buttonPanel.add(quitButton);

        loserPanel.add(loserMessage, BorderLayout.CENTER);
        loserPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.getContentPane().removeAll();
        loserPanel.setVisible(true);
        this.add(loserPanel);
        this.revalidate();
        this.repaint();
    }

    //method to show the stop screen when the player quits
    public void stopScreen() {
        stopPanel.removeAll();
        stopPanel.setLayout(new BorderLayout());

        //configure message and buttons
        stopMessage.setFont(new Font("Dialog", Font.BOLD, 50));
        resetButton.setFont(new Font("Dialog", Font.BOLD, 20));
        quitButton.setFont(new Font("Dialog", Font.BOLD, 20));
        stopMessage.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.add(resetButton);
        buttonPanel.add(quitButton);

        stopPanel.add(stopMessage, BorderLayout.CENTER);
        stopPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.getContentPane().removeAll();
        stopPanel.setVisible(true);
        this.add(stopPanel);
        this.revalidate();
        this.repaint();
    }

    //method to show the win screen when the player wins
    public void winScreen() {
        winnerPanel.removeAll();
        winnerPanel.setLayout(new BorderLayout());

        //configure message and buttons
        winnerMessage.setFont(new Font("Dialog", Font.BOLD, 50));
        resetButton.setFont(new Font("Dialog", Font.BOLD, 20));
        quitButton.setFont(new Font("Dialog", Font.BOLD, 20));
        winnerMessage.setHorizontalAlignment(SwingConstants.CENTER);
        winnerMessage.setText("You Won a Million Dollars!!");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.add(resetButton);
        buttonPanel.add(quitButton);

        winnerPanel.add(winnerMessage, BorderLayout.CENTER);
        winnerPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.getContentPane().removeAll();
        winnerPanel.setVisible(true);
        this.add(winnerPanel);
        this.revalidate();
        this.repaint();
    }

    //method to reset the game and return to the start screen
    public void resetPanel() {
        System.out.println("Game has been reset");
        this.getContentPane().removeAll();
        startScreen();

        this.revalidate();
        this.repaint();
    }
}
