/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zwty2
 */
public class MultiChoice extends Questions {

    private ArrayList<Integer> ids = new ArrayList<>();
    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<Character> answers = new ArrayList<>();
    private ArrayList<String> options = new ArrayList<>();

    public MultiChoice(Database database) {
        super(database);
    }

    @Override
    public void loadQuestions() {
        {
            try {
                Connection conn = database.conn;
                String query = "SELECT id, question_text, answer, question_options FROM multichoicequestions";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                        getIds().add(rs.getInt("id"));
                        getQuestions().add(rs.getString("question_text"));
                        getAnswers().add(rs.getString("answer").charAt(0));
                        getOptions().add(rs.getString("question_options"));
                }

                if (rs != null) {
                    rs.close();
                }
                preparedStatement.close();

            } catch (SQLException ex) {
                Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getQuestionById(int id) {
        return getQuestions().get(id);
    }

    public String getOptionById(int id) {
        return getOptions().get(id);
    }

    public char getAnswerById(int id) {
        return getAnswers().get(id);
    }

    /**
     * @return the ids
     */
    public ArrayList<Integer> getIds() {
        return ids;
    }

    /**
     * @return the questions
     */
    public ArrayList<String> getQuestions() {
        return questions;
    }

    /**
     * @return the answers
     */
    public ArrayList<Character> getAnswers() {
        return answers;
    }

    /**
     * @return the options
     */
    public ArrayList<String> getOptions() {
        return options;
    }
}
