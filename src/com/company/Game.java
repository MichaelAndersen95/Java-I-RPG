package com.company;

public class Game {
    private LevelHandler levelHandler = new LevelHandler();

    public void start() {

        Menu mainMenu = new Menu();
        mainMenu.Add("Show levels", new MenuCallback() {
            public void Invoke() {
                // Show levels
                levelHandler.showLevels();

            }
        });

        mainMenu.Add("Quit", new MenuCallback() {
            public void Invoke() {
                System.exit(0);
            }
        });

        mainMenu.Show();


        //levelHandler.showMap(level, y, x);


    }





}
