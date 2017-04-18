package hw4;

/**
 * This class returns the details of the card.
 * Number of squares and color of the card is returned
 *
 * @author Gaya
 */
public class Card {

    private int numberOfSquares;
    private SquareColor squareColor;

    /**
     * Initialize Card
     * @param numberOfSquares
     * @param squareColor
     */
    public Card(int numberOfSquares, SquareColor squareColor) {
        this.numberOfSquares = numberOfSquares;
        this.squareColor = squareColor;
    }

    /**
     * Get number of squares in a card
     * @return number of squares
     */
    public int getNumberOfSquares() {
        return numberOfSquares;
    }

    /**
     * Get square color
     * @return string, square color
     */
    public SquareColor getSquareColor() {
        return squareColor;
    }

    /**
     * Display card
     * @return card details
     */
    @Override
    public String toString() {
        return ("Number Of Squares in card:" + numberOfSquares + "\n" + "Card Color:" + squareColor);
    }

}
