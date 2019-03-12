public class BlackJackGame {

    Deck testDeck;
    Player player1;
    Player dealer;

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
    }

}
