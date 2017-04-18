package hw4;

import java.util.Scanner;

/**
 * @author Gaya 
 * CandyLandGame class - collaborates with main,Board,Card,Player
 * classes. Game play is handled in this class
 */
public class CandyLandGame {

    private Board board;
    private CardPack cardpack;
    private Player player1;
    private Player player2;

    /**
     * Initialize the candy land game
     * @param player1
     * @param player2
     */
    public CandyLandGame(Player player1, Player player2) {
        // we are constructing board and cardpack
        this.board = new Board();
        this.cardpack = new CardPack();
        this.player1 = player1;
        this.player2 = player2;
    }    

    /**
     * Game play. 
     * Steps involved in the game play are:
     * - Each player takes turns to flip card. 
     * - Board, card and player current position is displayed.
     * - Get the player's new position.
     * - Validate the player entered position.
     * - When a player wins, that player's information is returned.
     *
     * @return player, winner of the game will be returned
     */
    public Player runGame() {
        boolean turn = true;
        while (!board.isEndSquare(player1) && !board.isEndSquare(player2)) {
            Player player = (turn) ? player1 : player2;
            String playerInformation = (turn) ? "Player 1" : "Player 2";
            System.out.println(playerInformation);
            System.out.println("Press Enter to Flip Card");
            Scanner input = new Scanner(System.in);
            input.nextLine();
            System.out.println(board);
            Card card = cardpack.flipCard();
            System.out.println(card);
            System.out.println("Player Current Position :" + player.getPlayerCurrentPosition());
            System.out.println("Enter your new position on the board \ncheck for bridges if you landed on one then enter position accordingly ");
            int playerEnteredPosition = input.nextInt();
            if (board.isCorrectPosition(playerEnteredPosition, card, player)) {
                player.setPlayerCurrentPosition(playerEnteredPosition);
            } else {
                System.err.println("You have entered the wrong position,Please try again by picking another card");
                continue;
            }
            turn = !turn;
        }
        if (board.isEndSquare(player1)) {
            return player1;
        } else {
            return player2;
        }
    }
}
