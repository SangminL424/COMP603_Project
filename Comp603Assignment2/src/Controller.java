import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    View view = new View();
    
    public Controller(View view){
        this.view = view;
        
        view.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked the start button");
            }
        });
    }
}
