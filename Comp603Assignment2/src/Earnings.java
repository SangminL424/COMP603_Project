/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author zwty2
 */
public class Earnings {

    private int earnings = 0;

    public void earningsPerRound(int round) {  //amount of earned money goes up every round

        switch (round) {  //for every round the amount of earnings go up
            case 0:
                earnings = 50;
                break;
            case 1:
                earnings = 100;
                break;
            case 2:
                earnings = 500;
                break;
            case 3:
                earnings = 1000;
                break;
            case 4:
                earnings = 5000;
                break;
            case 5:
                earnings = 10000;
                break;
            case 6:
                earnings = 50000;
                break;
            case 7:
                earnings = 100000;
                break;
            case 8:
                earnings = 500000;
                break;
            case 9:
                earnings = 1000000;
                break;
        }
    }

    public void printCurrentEarnings(int round) {  //prints the current amount of earnings
        earningsPerRound(round);  //gets the current rounds earning amount

        System.out.println("Your current earnings are: $" + getEarnings());  //prints the player's current earnings
    }

    /**
     * @return the earnings
     */
    public int getEarnings() {  //getter
        return earnings;
    }
}
