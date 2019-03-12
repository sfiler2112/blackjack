import java.util.Scanner;

public class CardMain {

    public static void main(String[] args)
    {
        askToPlay();
    }

    public static void askToPlay()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Play blackjack? (y/n): ");
        String answer = userInput.next();

        if(answer.equals("y"))
        {
            BlackJack();
        } else if(answer.equals("n"))
        {
            System.out.println("oh... ok then.");
        } else {
            System.out.println("huh?");
            askToPlay();
        }
    }

    public static void BlackJack()
    {
        BlackJackGame game = new BlackJackGame();
        game.play();
    }
}
