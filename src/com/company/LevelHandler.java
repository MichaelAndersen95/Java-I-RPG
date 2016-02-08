package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class LevelHandler {

    private PlayerHandler playerHandler = new PlayerHandler();

    public String[][] loadLevelFromFile(String filename) throws FileNotFoundException {

        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);

        Integer intLength = 0;
        String[] length = in.nextLine().trim().split("\\s+");
        for (Integer i = 0; i < length.length; i++) {
            intLength++;
        }

        in.close();

        String[][] level = new String[intLength][intLength];
        in = new Scanner(inFile);

        Integer lineCount = 0;
        while (in.hasNextLine()) {
            String[] currentLine = in.nextLine().trim().split("\\s+");
            for (Integer i = 0; i < currentLine.length; i++) {
                level[lineCount][i] = (currentLine[i]);
            }
            lineCount++;
        }

        level[4][2] = "X";

        return level;

    }

    public void showLevels() {
        System.out.println("Please choose a level");

        Menu menu = new Menu();

        URL url = LevelHandler.class.getResource("Levels/");
        if (url == null) {
            // error - missing folder
            System.out.print("Can't find Levels folder");
        } else {
            File dir = null;
            try {
                dir = new File(url.toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            for (File nextFile : dir.listFiles()) {
                // Add each level to menu

                menu.Add(nextFile.getName(), new MenuCallback() {
                    public void Invoke() {
                        System.out.println("Loading "+nextFile.getName()+"\n");

                        try {
                            String level[][] = loadLevelFromFile(nextFile.getPath());
                            Integer y = 4;
                            Integer x = 2;
                            playerHandler.showMap(level);
                            playerHandler.playerMove(level, y, x);
                        } catch (FileNotFoundException e){
                            e.printStackTrace();
                        }

                    }
                });
            }
        }
        menu.Show();
    }


}
