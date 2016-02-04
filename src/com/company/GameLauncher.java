package com.company;

import java.util.Scanner;

public class GameLauncher {
    private Scanner input = new Scanner(System.in);
    private String userInput;
    private LevelHandler lLoader = new LevelHandler();

    public void start() {
        //userInput = input.nextLine();
        lLoader.loadLevel();

    }
}
