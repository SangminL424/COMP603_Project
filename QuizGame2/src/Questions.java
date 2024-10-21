
public abstract class Questions {

    Database database;
    
    //constructor that takes a database object object and assigns it to the class field
    public Questions(Database database) {
        this.database = database;
    }

    //abstract method to be implemented by subclasses for loading questions
    public abstract void loadQuestions();
    
    
}
