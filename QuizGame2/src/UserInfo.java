
public class UserInfo {

    private String username;
    private int score = 0;

    //method to increase the user's earnings per round by certain amounts
    public void earningsPerRound(int round) {  //amount of earned money goes up every round

        switch (round) {  //for every round the amount of earnings go up
            case 0:
                setScore(50);
                break;
            case 1:
                setScore(100);
                break;
            case 2:
                setScore(500);
                break;
            case 3:
                setScore(1000);
                break;
            case 4:
                setScore(5000);
                break;
            case 5:
                setScore(10000);
                break;
            case 6:
                setScore(50000);
                break;
            case 7:
                setScore(100000);
                break;
            case 8:
                setScore(500000);
                break;
            case 9:
                setScore(1000000);
                break;
        }
    }
    
    
    //getter and setter methods for username and score
    public String getUsername() {  //getter
        return username;
    }

    public void setUsername(String username) {  //setter
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
