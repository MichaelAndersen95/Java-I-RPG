package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class MapLoader {

    private final PlayerHandler playerHandler = new PlayerHandler();

    /**
     * Not working if JAR file
     * @param filename loads the specified map from the Maps folder
     * @return returns a map
     * @throws FileNotFoundException
     */
    public String[][] loadMapFromFile(String filename) throws FileNotFoundException {

        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);

        Integer intLength = 0;
        String[] length = in.nextLine().trim().split("\\s+");
        for (String aLength : length) {
            intLength++;
        }
        in.close();

        String[][] map = new String[intLength][intLength];
        in = new Scanner(inFile);

        Integer lineCount = 0;
        while (in.hasNextLine()) {
            String[] currentLine = in.nextLine().trim().split("\\s+");
            System.arraycopy(currentLine, 0, map[lineCount], 0, currentLine.length);
            lineCount++;
        }

        map[6][3] = "X";

        return map;
    }

    /**
     * Puts each map into a menu
     * @param player sends the player object to getDirectionChoice
     */
    public void showMaps(Player player) {
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

                menu.Add(nextFile.getName(), () -> {
                    System.out.println("Loading "+nextFile.getName()+"\n");

                    try {
                        String level[][] = loadMapFromFile(nextFile.getPath());
                        Integer y = 6;
                        Integer x = 3;
                        playerHandler.showMap(level);
                        playerHandler.getDirectionChoice(level, y, x, player);
                    } catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                });
            }
        }
        menu.Show();
    }
}
