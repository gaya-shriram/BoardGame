package hw4;

/**
 * @author Gaya 
 * This class contains player name,coin color and player current position.
 */
public class Player {

    private String playerName;
    private String playerCoinColor;
    private int playerCurrentPosition;

    /**
     * Initialize player
     * @param playerName
     * @param playerCoinColor
     */
    public Player(String playerName, String playerCoinColor) {
        this.playerName = playerName;
        this.playerCoinColor = playerCoinColor;
        this.playerCurrentPosition = 0;
    }

    /**
     * Get Player name
     * @return player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Get player coin color
     * @return coin color
     */
    public String getCoinColor() {
        return playerCoinColor;
    }

    /**
     * Get player current position
     * @return player current position
     */
    public int getPlayerCurrentPosition() {
        return playerCurrentPosition;
    }

    /**
     * Set player current position
     * @param currentPosition
     */
    public void setPlayerCurrentPosition(int currentPosition) {
        this.playerCurrentPosition = currentPosition;
    }

    /**
     * Display player details
     * @return player details
     */
    @Override
    public String toString() {
        return ("Player Name :" + playerName + "\t Player Coin Color :" + playerCoinColor);
    }
}

