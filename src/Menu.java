package hw4;

import java.util.Scanner;

/**
 * @author Gaya 
 * Menu class - to display the menu details about the game to the player
 */
public class Menu {
    private final String[] choices;

    /** 
     * Initialize the menu
     * @param choices 
     */
    public Menu(String[] choices) {
        this.choices = choices;
    }

    /**
     * Get the menu choice from the user
     *
     * @return the user choice
     */
    public int get() {
        System.out.println("Please choose one of the following: ");
        for (int i = 0; i < this.choices.length; ++i) {
            System.out.println(i + ". " + choices[i]);
        }
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
