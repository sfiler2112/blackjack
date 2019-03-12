import java.util.LinkedList;

public class Player {
    private int score;
    private LinkedList<Card> hand = new LinkedList<>();
    private boolean busted;
    private String playerName;

    public Player(String name)
    {
        score = 0;
        busted = false;
        playerName = name;
    }

    public void takeCard(Card newCard)
    {
        hand.add(newCard);
        score+=newCard.getValue();
        if(score > 21)
        {
            busted = true;
        }
    }

    public void showHand()
    {
        System.out.println(playerName + "'s cards:");

        for(int i = 0; i < hand.size(); i++)
        {
            System.out.println(hand.get(i).getCardInfo());
        }
        System.out.println("Score: " + getScore());

    }

    public int getScore()
    {
        return score;
    }

    public boolean isBusted()
    {
        return busted;
    }

}
