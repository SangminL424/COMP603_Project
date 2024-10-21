public class QuizMain {
    
    //main method
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);
        
        //make the GUI visible
        view.setVisible(true);
    }
}
