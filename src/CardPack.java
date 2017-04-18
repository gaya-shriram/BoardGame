package hw4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gaya 
 * This class is newly added to the design. 
 * Card pack was not handled as part of the initial design. 
 * Card pack is used to store the list of cards created. 
 */
public class CardPack {

    private List<Card> cardPack;

    /**
     * Adding cards to the card pack
     */
    public CardPack() {
        cardPack = new ArrayList<Card>();
        for (SquareColor squareColor : SquareColor.values()) {
            //adding single square cards to the card pack
            for (int index = 0; index < 8; index++) {
                Card card = new Card(1, squareColor);
                cardPack.add(card);
            }
            //adding two square cards to the card pack 
            cardPack.add(new Card(2, squareColor));
            cardPack.add(new Card(2, squareColor));

        }
    }

    /**
     * Initialize card pack
     * @param cardPack
     */
    public CardPack(List<Card> cardPack) {
        this.cardPack = cardPack;
    }

    /**
     * random method is used to generate a random card during each move.
     *
     * @return returns a random card
     */
    public Card flipCard() {
        int randomIndex = (int) (Math.random() * 100) % cardPack.size();
        return cardPack.get(randomIndex);
    }

}
