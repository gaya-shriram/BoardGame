package hw4;

import java.util.Scanner;

/**
 * @author Gaya 
 * MainGame class - processing the choices getting the player
 * information for the player1 and player2
 */
public class MainGame {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        String[] commands = {"Quit Game", "Add Player1", "Add Player2", "Start Game"};
        final int QUIT = 0, // 0 is code to quit the program
                ADDPLAYER1 = 1,
                ADDPLAYER2 = 2,
                STARTGAME = 3;
        Menu choices = new Menu(commands);
        int choice;
        Player player1 = null, player2 = null;

        System.out.println("********WELCOME TO CANDY LAND********");
        while ((choice = choices.get()) != QUIT) {
            switch (choice) {
                case ADDPLAYER1:
                    player1 = getPlayerInformation();
                    break;

                case ADDPLAYER2:
                    player2 = getPlayerInformation();
                    break;
                case STARTGAME:
                    if (player1 == null) {
                        System.err.println("Please Enter Player 1 Details");
                        continue;
                    }

                    if (player2 == null) {
                        System.err.println("Please Enter Player 2 Details");
                        continue;
                    }

                    if (player1.getCoinColor() == null ? player2.getCoinColor() == null
                            : player1.getCoinColor().equals(player2.getCoinColor())) {
                        System.err.println("Please re-enter different coin color for one of the player");
                        continue;
                    }
                    CandyLandGame game = new CandyLandGame(player1, player2);
                    Player winner = game.runGame();
                    System.out.println("The Winner Is :" + winner);

                    break;
                case QUIT:
                    return;
                default:
                    System.err.println("Invalid Option");

            }

        }

    }

    private static Player getPlayerInformation() {

        System.out.println("Enter the player name");
        Scanner input = new Scanner(System.in);
        String playerName = input.next();
        System.out.println("Enter the player coin color");
        String playerCoinColor = input.next();
        Player player = new Player(playerName, playerCoinColor);
        return player;

    }

}
