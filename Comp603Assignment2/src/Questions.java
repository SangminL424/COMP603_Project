/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author zwty2
 */
public abstract class Questions {

    Database database;
    
    public Questions(Database database) {
        this.database = database;
    }

    public abstract void loadQuestions();
    
    
}
