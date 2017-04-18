package hw4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gaya 
 * Board class - Creates a board with list of squares and 2 bridges
 */
public class Board {

    // To represent a Square in a board
    private class Square {
        
        private final SquareColor squareColor;
        private final int squarePosition;

        Square(SquareColor squareColor, int squarePosition) {
            this.squareColor = squareColor;
            this.squarePosition = squarePosition;
        }

        public SquareColor getSquareColor() {
            return squareColor;
        }

        public int getSquarePosition() {
            return squarePosition;
        }

        @Override
        public String toString() {
            return squarePosition + ":" + squareColor;
        }
    }

    // To represent a Bridge in a board
    private class Bridge {
        
        private Square startSquare;
        private Square endSquare;

        Bridge(Square startSquare, Square endSquare) {
            this.startSquare = startSquare;
            this.endSquare = endSquare;
        }

        public Square getStartSquare() {
            return startSquare;
        }

        public Square getEndSquare() {
            return endSquare;
        }

        @Override
        public String toString() {
            return startSquare + "----->" + endSquare;
        }
    }

    private List<Square> squares;
    private List<Bridge> bridges;

    /**
     * Initialize the board
     * set squares
     * set the bridges from one square to another square
     */
    public Board() {
        squares = new ArrayList<Square>();
        SquareColor[] colors = SquareColor.values();
        for (int position = 0; position < 60; position++) {
            int squareColorIndex = position % colors.length;
            Square square = new Square(colors[squareColorIndex], position);
            squares.add(square);
        }
        bridges = new ArrayList<Bridge>();
        Bridge bridge1 = new Bridge(squares.get(5), squares.get(15));
        Bridge bridge2 = new Bridge(squares.get(25), squares.get(35));
        bridges.add(bridge1);
        bridges.add(bridge2);
    }

    /**
     * Check the player entered position in the board
     * @param playerEnteredPosition
     * @param card
     * @param player
     * @return true, if the player entered position is correct 
     */
    public boolean isCorrectPosition(int playerEnteredPosition, Card card, Player player) {
        return playerEnteredPosition == getNewPosition(card, player.getPlayerCurrentPosition());
    }

    private int getNewPosition(Card card, int playerCurrentPosition) {
        int numberOfSquares = 1;
        for (int index = playerCurrentPosition + 1; index < this.squares.size(); index++) {
            if (card.getSquareColor() == this.squares.get(index).getSquareColor()) {
                if (card.getNumberOfSquares() == numberOfSquares) {
                    Square landingSquare = this.squares.get(index);
                    //check for bridge
                    for (Bridge bridge : bridges) {
                        if (bridge.getStartSquare().getSquarePosition() == landingSquare.getSquarePosition()) {
                            return bridge.getEndSquare().getSquarePosition();
                        }
                    }
                    return landingSquare.getSquarePosition();
                } else {
                    numberOfSquares = numberOfSquares + 1;
                }
            }
        }
        return playerCurrentPosition;
    }

    /**
     * Check if the player lands anywhere on the last row 
     * @return true, if the player lands anywhere on the last row 
     */
    public boolean isEndSquare(Player player) {
        return this.squares.get(this.squares.size() - 6).getSquarePosition() <= player.getPlayerCurrentPosition();
    }

    /**
     * Display Board
     * @return board representation
     */
    @Override
    public String toString() {
        String output = "BOARD";
        for (int index = 0; index < this.squares.size(); index++) {
            if (index % 6 == 0) {
                output = output + "\n";
            }
            output = output + this.squares.get(index) + "\t" + "\t";
        }
        output = output + "\n\nBridges in the board:\n";
        for (Bridge bridge : bridges) {
            output = output + bridge + "\n";
        }
        return output;
    }

}
