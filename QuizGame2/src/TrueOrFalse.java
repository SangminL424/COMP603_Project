
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrueOrFalse extends Questions {

    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<Character> answers = new ArrayList<>();
    private ArrayList<String> options = new ArrayList<>();

    //constructor that takes a database object and passes it to the super class Questions
    public TrueOrFalse(Database database) {
        super(database);
    }

    //Overide the method to load the questions, answers and options from the trueorfalsequestions table of the database into ArrayLists
    @Override
    public void loadQuestions() {
        {
            try {
                Connection conn = database.conn;
                String query = "SELECT question_text, answer, question_options FROM trueorfalsequestions";

                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
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

    //getter methods for getting questions, answers, options
    public ArrayList<String> getQuestions() {
        return questions;
    }

    public ArrayList<Character> getAnswers() {
        return answers;
    }

    public ArrayList<String> getOptions() {
        return options;
    }
}
