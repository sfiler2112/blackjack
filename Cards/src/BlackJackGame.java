import java.util.Scanner;

public class BlackJackGame {

    private Deck testDeck;
    private Player player1;
    private Player dealer;
    Scanner playerInput = new Scanner(System.in);

    public BlackJackGame()
    {
        testDeck = new Deck(2);
        testDeck.shuffle();
        player1 = new Player("player");
        dealer = new Player("dealer");
    }

    public void play()
    {
        System.out.println("Starting new round of play...");

        player1.takeCard(testDeck.dealCard());
        dealer.takeCard(testDeck.dealCard());
        player1.takeCard(testDeck.dealCard());
        dealer.takeCard(testDeck.dealCard());

        player1.showHand();
        dealer.showHand();

        actionTo(player1);
        actionTo(dealer);

        finishRound();
    }

    private void actionTo(Player currentPlayer)
    {
        System.out.println(currentPlayer.getPlayerName()+"'s turn...");

        boolean stay = false;
        while(!currentPlayer.isBusted() && !stay)
        {
            System.out.println("Score is " + currentPlayer.getScore() + ". Hit or stay? (h/s):");

            switch(playerInput.next())
            {
                case "h":
                    currentPlayer.takeCard(testDeck.dealCard());
                    currentPlayer.showHand();
                    break;
                case "s":
                    stay = true;
                    break;
                default:
                    break;
            }
        }

        if(!currentPlayer.isBusted())
        {
            System.out.println("Staying with score of " + currentPlayer.getScore() + "...");
        } else {
            System.out.println(currentPlayer.getPlayerName() + " busted!");
        }
    }

    private void finishRound()
    {
        if(!player1.isBusted() && ((player1.getScore() > dealer.getScore()) || dealer.isBusted()))
        {
            System.out.println(player1.getPlayerName() + " has won this hand!");
        } else {
            System.out.println(dealer.getPlayerName() + " has won the hand.");
        }
        reset();

        System.out.println("Want to play another round? (y/n):");

        switch(playerInput.next())
        {
            case "y":
                play();
                break;
            case "n":
                System.out.println("See you later!");
                break;
            default:
                finishRound();
                break;
        }
    }


    private void reset()
    {
        player1.reset();
        dealer.reset();
    }

}
