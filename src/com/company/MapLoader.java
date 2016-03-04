package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class MapLoader {

    private final PlayerHandler playerHandler = new PlayerHandler();
    private final UI ui = new UI();
    private String fileError = "\nFile not found\n";

    /**
     * @param filename loads the specified map from the Maps folder
     * @return returns a map
     * @throws FileNotFoundException
     */
    public String[][] loadMapFromFile(String filename) {

        File inFile = new File(filename);
        Scanner in;
        String[][] map = null;

        try {
            in = new Scanner(inFile);

            Integer intLength = 0;
            String[] length = in.nextLine().trim().split("\\s+");
            for (String aLength : length) {
                intLength++;
            }
            in.close();

            map = new String[intLength][intLength];

            in = new Scanner(inFile);


            Integer lineCount = 0;
            while (in.hasNextLine()) {
                String[] currentLine = in.nextLine().trim().split("\\s+");
                System.arraycopy(currentLine, 0, map[lineCount], 0, currentLine.length);
                lineCount++;
            }

            map[6][3] = "X";

        } catch (FileNotFoundException e) {
            ui.print(fileError);
        }

        return map;
    }

    /**
     * Puts each map into a menu
     * @param player sends the player object to getDirectionChoice
     */
    public void showMaps(Player player) {
        ui.print("Please choose a map\n");
        Menu menu = new Menu();
        URL url = MapLoader.class.getResource("Maps/");
        File dir;

        if (url == null) {
            // error - missing folder
            ui.print("Can't find Maps folder");
        } else {
            try {
                dir = new File(url.toURI());

                // Add each level to menu
                for (File nextFile : dir.listFiles()) {

                    menu.Add(nextFile.getName(), () -> {
                        String level[][] = loadMapFromFile(nextFile.getPath());
                        Integer y = 6;
                        Integer x = 3;
                        ui.clear();
                        playerHandler.showMap(level);
                        playerHandler.getDirectionChoice(level, y, x, player);
                    });
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        menu.Show();
    }
}
