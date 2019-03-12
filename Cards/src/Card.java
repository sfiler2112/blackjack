public class Card {

    private int cardValue;
    private String suite;
    private String cardType;
    private Boolean faceCard = false;

    public Card(String suiteArg, int cardValueArg)
    {
        suite = suiteArg;

        if(cardValueArg > 14 || cardValueArg < 2)
        {
            System.out.println("invalid card value");
        } else {
            cardValue = cardValueArg;
            if(cardValueArg > 10)
            {
                faceCard = true;
                createFaceCard();
            } else {
                createNumberCard();
            }
        }
    }

    private void createNumberCard()
    {
        cardType = Integer.toString(cardValue);
    }

    private void createFaceCard()
    {
        switch(cardValue)
        {
            case 11:
                cardType = "jack";
                break;
            case 12:
                cardType = "queen";
                break;
            case 13:
                cardType = "king";
                break;
            case 14:
                cardType = "ace";
                break;
        }
    }

    public String getCardInfo()
    {
        return cardType + " of " + suite;
    }

    public int getValue()
    {
        if(!faceCard)
        {
            return cardValue;
        } else {
            if(cardType=="ace")
            {
                return 11;
            } else {
                return 10;
            }
        }
    }



}
