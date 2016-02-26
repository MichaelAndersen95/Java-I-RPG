package com.company;

import java.sql.SQLException;
import java.util.Scanner;

class Game {
    private final MapLoader mapLoader = new MapLoader();
    HighScoreHandler highScoreHandler = new HighScoreHandler();

    /**
     * Start the main loop the game is running in, and show the main menu to the player
     */
    public void start() {
        Boolean gameStarted = true;
        Player player = new Player(getPlayerName(), 15, 1, "punch", 2, 3, 0);

        while (gameStarted) {

            Menu mainMenu = new Menu();
            mainMenu.Add("Show maps", () -> mapLoader.showMaps(player));
            mainMenu.Add("Show high scores", () -> {
                try {
                    highScoreHandler.getAllHighScores();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            mainMenu.Add("Quit", () -> System.exit(0));

            mainMenu.Show();

        }
    }

    private String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name(no spaces): ");
        return scanner.next();
    }

}
