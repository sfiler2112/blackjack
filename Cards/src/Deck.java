import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Deck {

    private int standardDeckSize = 52;
    private String[] suites = {"diamond", "heart", "spade", "club"};
    private int suiteSize = 13;
    private Deque<Card> cards ;
    private int cardBase;

    public Deck()
    {
        cards = new ArrayDeque<Card>(standardDeckSize);
        createDeck();

    }


    public Deck(int numDecks)
    {
        cards = new ArrayDeque<Card>(standardDeckSize*numDecks);
        for(int i = 0; i < numDecks; i++)
        {
            createDeck();
        }
    }


    private void createDeck()
    {
        Card newCard;
        for(int i = 0; i < suites.length; i++)
        {

            for(int j = 0; j < suiteSize; j++)
            {
                newCard = new Card(suites[i], j + 2);
                cards.push(newCard);
            }
        }
    }



    public void printDeck()
    {
        Deque<Card> tempCards = new ArrayDeque<>(cards.size());
        Card currentCard;
        while(!cards.isEmpty())
        {
            currentCard = cards.pop();
            System.out.println(currentCard.getCardInfo());
            tempCards.push(currentCard);
        }

        cards = tempCards;
    }

    public int getDeckSize()
    {
        return cards.size();
    }

    public int shuffle()
    {
        Random randomIndex = new Random();
        Card cardArray[] = new Card[cards.size()];
        int trackLoop = 0;
        while(!cards.isEmpty())
        {
            int index = randomIndex.nextInt(cardArray.length);

            if(cardArray[index]==null)
            {
                cardArray[index] = cards.pop();
            }
            trackLoop++;

        }

        for(int i = 0; i<cardArray.length; i++)
        {
            cards.push(cardArray[i]);
        }

        return trackLoop;

    }

    public Card dealCard()
    {
        return cards.pop();
    }
}
