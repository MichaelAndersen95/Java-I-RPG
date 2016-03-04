package com.company;

import java.util.Scanner;

class Game {
    private final MapLoader mapLoader = new MapLoader();
    private final HighScoreHandler highScoreHandler = new HighScoreHandler();
    private final UI ui = new UI();

    /**
     * Start the main loop the game is running in, and show the main menu to the player
     */
    public void start() {
        Boolean gameStarted = true;
        Player player = new Player(getPlayerName(), 15, "punch", 2, 3);

        while (gameStarted) {

            ui.clear();
            Menu mainMenu = new Menu();
            mainMenu.Add("Show maps", () -> mapLoader.showMaps(player));
            mainMenu.Add("Show high scores (highest score)", highScoreHandler::getAllHighScoresByScore);
            mainMenu.Add("Show high scores (most kills)", highScoreHandler::getAllHighScoresByKills);
            mainMenu.Add("Export high scores from DB to XML", highScoreHandler::exportDBToXML);
            mainMenu.Add("Show High Scores From XML", highScoreHandler::getHighScoresFromXML);
            mainMenu.Add("Quit", () -> System.exit(0));

            mainMenu.Show();

        }
    }

    private String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        String output = "Enter your name(no spaces): ";
        ui.print(output);
        return scanner.next();
    }

}
