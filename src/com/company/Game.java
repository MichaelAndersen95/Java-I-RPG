package com.company;

public class Game {
    private MapLoader mapLoader = new MapLoader();

    public void start() {

        Menu mainMenu = new Menu();
        mainMenu.Add("Show maps", new MenuCallback() {
            public void Invoke() {
                mapLoader.showMaps();

            }
        });

        mainMenu.Add("Quit", new MenuCallback() {
            public void Invoke() {
                System.exit(0);
            }
        });

        mainMenu.Show();


        //mapLoader.showMap(level, y, x);


    }





}
