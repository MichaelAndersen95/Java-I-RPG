package com.company;

class Game {
    private final MapLoader mapLoader = new MapLoader();
    private final Player player = new Player(15, 1, "punch", 2, 3, 1);


    /**
     * Start the main loop the game is running in, and show the main menu to the player
     */
    public void start() {

        Boolean gameStarted = true;

        while (gameStarted) {

            Menu mainMenu = new Menu();
            mainMenu.Add("Show maps", () -> mapLoader.showMaps(player));

            mainMenu.Add("Quit", () -> System.exit(0));

            mainMenu.Show();

        }
    }
}
