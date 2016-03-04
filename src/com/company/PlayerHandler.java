package com.company;

public class PlayerHandler {

    private String[][] aMap;
    private Integer prevX;
    private Integer prevY;
    private Player aPlayer;
    private final HighScoreHandler highScoreHandler = new HighScoreHandler();
    private final UI ui = new UI();

    /**
     * move player up
     * @param y players y position
     * @return y plus one
     */
    public Integer moveUp(Integer y) {
        y--;
        return y;
    }
    /**
     * move player down
     * @param y players y position
     * @return y minus one
     */
    public Integer moveDown(Integer y) {
        y++;
        return y;
    }
    /**
     * move player right
     * @param x players x position
     * @return x plus one
     */
    public Integer moveRight(Integer x) {
        x++;
        return x;
    }
    /**
     * move player up
     * @param x players x position
     * @return x minus one
     */
    public Integer moveLeft(Integer x) {
        x--;
        return x;
    }

    /**
     * Moves the player around the map
     * @param map the map to move the player in
     * @param y y position
     * @param x x position
     * @param player the player object
     */
    public void getDirectionChoice(String[][] map, Integer y, Integer x, Player player) {

        aMap = map;
        aPlayer = player;
        prevY = y;
        prevX = x;

        if (aPlayer.isAlive()) {
            Menu movementChoice = new Menu();

            movementChoice.Add("Move up", () -> checkPosition(moveUp(y), x));
            movementChoice.Add("Move down", () -> checkPosition(moveDown(y), x));
            movementChoice.Add("Move right", () -> checkPosition(y, moveRight(x)));
            movementChoice.Add("Move left", () -> checkPosition(y, moveLeft(x)));
            movementChoice.Show();
        } else {
            ui.print("Looks like you died, better luck next time\n");
            ui.print("----- Your score was: "+player.getScore()+" -----\n");

            highScoreHandler.saveHighScore(player.getName(), player.getScore(), player.getKills());
            System.exit(0);
        }
    }

    /**
     * checks if the position the player want to go to is possible
     * @param y players y position
     * @param x players x position
     */
    private void checkPosition(Integer y, Integer x) {

        BattleHandler battleHandler = new BattleHandler();

        try {
            switch (aMap[y][x]) {
                case "#":
                    ui.print("You walked into a wall, try walking another way.\n");
                    aMap[prevY][prevX] = "X";
                    setPosition(prevY, prevX);
                    break;
                case "+":
                    battleHandler.startBattle(aPlayer);
                    setPosition(y, x);
                    break;
                case "O":
                    ui.print("Congratulations!\nYou survived this level, please select another!\n");
                    break;
                default:
                    setPosition(y, x);
                    break;
        }
            //player went outside map (happens on testmap.txt)
        } catch (Exception e) {
            ui.print("You can't go out of the map.\n");
            showMap(aMap);
            getDirectionChoice(aMap, y, x, aPlayer);
        }
    }

    /**
     * @param y players y position on the map
     * @param x players y position on the map
     */
    private void setPosition(Integer y, Integer x) {

        aMap[prevY][prevX] = ".";
        aMap[y][x] = "X";
        ui.clear();
        showMap(aMap);
        getDirectionChoice(aMap, y, x, aPlayer);
    }

    /**
     * @param map prints out the map
     */
    public void showMap(String[][] map) {

        //ui.clear();

        Integer i, j;

        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map.length; j++)
                ui.print(map[i][j] + "  ");
            ui.print("\n");
        }
    }
}
