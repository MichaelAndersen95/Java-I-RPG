package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class MapLoader {

    private PlayerHandler playerHandler = new PlayerHandler();

    public String[][] loadMapFromFile(String filename) throws FileNotFoundException {

        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);

        Integer intLength = 0;
        String[] length = in.nextLine().trim().split("\\s+");
        for (Integer i = 0; i < length.length; i++) {
            intLength++;
        }
        in.close();

        String[][] map = new String[intLength][intLength];
        in = new Scanner(inFile);

        Integer lineCount = 0;
        while (in.hasNextLine()) {
            String[] currentLine = in.nextLine().trim().split("\\s+");
            for (Integer i = 0; i < currentLine.length; i++) {
                map[lineCount][i] = (currentLine[i]);
            }
            lineCount++;
        }

        map[6][3] = "X";

        return map;
    }

    public void showMaps() {
        System.out.println("Please choose a map");

        Menu menu = new Menu();

        URL url = MapLoader.class.getResource("Maps/");
        if (url == null) {
            // error - missing folder
            System.out.print("Can't find Maps folder");
        } else {
            File dir = null;
            try {
                dir = new File(url.toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            // Add each level to menu
            for (File nextFile : dir.listFiles()) {

                menu.Add(nextFile.getName(), new MenuCallback() {
                    public void Invoke() {
                        System.out.println("Loading "+nextFile.getName()+"\n");

                        try {
                            String level[][] = loadMapFromFile(nextFile.getPath());
                            Integer y = 6;
                            Integer x = 3;
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
