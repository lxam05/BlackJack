import java.util.Scanner;
import java.util.Random;

public class MakingAGameLab5 {
    public static void main(String[] args){

        gameBackgroud g = new gameBackgroud();

        while(g.initialValue <= 21) {

            g.ContinueGame();

            if(g.initialValue > 21){
                System.out.println("You went bust");
                break;
            }
            else if(g.initialValue == 21) {
                System.out.println("CONGRATULATIONS YOU HIT 21!! ");
                break;
            }
            else if(g.userChoice.equalsIgnoreCase("HOLD")) {
                System.out.println("You held at: " + g.initialValue);
                break;
            }
        }
    }
}

/*
 * 3 outcomes
 *  1. score 21 - they win
 *  2. score > 21 - they lose
 *  3. draw as its a one player game
 */

 class gameBackgroud{

    int initialValue;
    String name;
    String userChoice;

    Random rand = new Random();
    gameBackgroud.Cards[] c = gameBackgroud.Cards.values();
    Scanner s = new Scanner(System.in);


    enum Cards{
        Ace(1),
        two(2),
        three(3),
        four(4),
        five(5),
        six(6),
        seven(7),
        eight(8),
        nine(9),
        ten(10),
        jack(10),
        queen(10),
        king(10);

        int cardValue;

        Cards(int cardValue) {
            this.cardValue = cardValue;
        }

        public int getCard(){
            return this.cardValue;
        }
    }
    
    gameBackgroud(){

        System.out.println("Enter your name: ");
        this.name = s.nextLine();
        String name = this.name;

        gameBackgroud.Cards random1 = c[rand.nextInt(c.length)];
        gameBackgroud.Cards random2 = c[rand.nextInt(c.length)];

        System.out.println("HERE: " + random1.getCard());
        System.out.println("HERE: " + random2.getCard());

        this.initialValue = (random1.getCard() + random2.getCard());
        System.out.println("Player: " + name + "; has " + initialValue);
    }

    int ContinueGame() {

        if(initialValue == 21){
            return initialValue;
        }
        gameBackgroud.Cards r = c[rand.nextInt(c.length)];
        System.out.println("Do you want to DRAW another card, or HOLD? ");
        userChoice = s.nextLine();

        if(userChoice.equalsIgnoreCase("HOLD")){
            System.out.println("return");
            return initialValue;
        }
        else if(userChoice.equalsIgnoreCase("DRAW")){
            this.initialValue += r.getCard();
            System.out.println("Your value is: " + initialValue);
        }
        return initialValue;
    }
 }