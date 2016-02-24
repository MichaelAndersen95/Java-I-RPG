package com.company;

class PlayerHandler {

    public String[][] aMap;
    Integer prevX;
    Integer prevY;
    Player aPlayer;

    public void moveUp(Integer y, Integer x) {
        prevY = y;
        prevX = x;
        y--;
        checkPosition(y, x);
    }
    public void moveDown(Integer y, Integer x) {
        prevY = y;
        prevX = x;
        y++;
        checkPosition(y, x);
    }
    public void moveRight(Integer y, Integer x) {
        prevY = y;
        prevX = x;
        x++;
        checkPosition(y, x);
    }
    public void moveLeft(Integer y, Integer x) {
        prevY = y;
        prevX = x;
        x--;
        checkPosition(y, x);
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

        if (aPlayer.isAlive()) {
            Menu movementChoice = new Menu();
            movementChoice.Add("Move up", () -> moveUp(y, x));
            movementChoice.Add("Move down", () -> moveDown(y, x));
            movementChoice.Add("Move right", () -> moveRight(y, x));
            movementChoice.Add("Move left", () -> moveLeft(y, x));
            movementChoice.Show();
        } else {
            System.out.println("Looks like you died, better luck next time.\n\n");
            System.exit(0);
        }
    }

    private void checkPosition(Integer y, Integer x) {

        BattleHandler battleHandler = new BattleHandler();

        switch (aMap[y][x]) {
            case "#":
                System.out.print("You walked into a wall, try walking another way.");
                aMap[prevY][prevX] = "X";
                setPosition(prevY, prevX);
                break;
            case "+":
                battleHandler.startBattle(aPlayer);
                setPosition(y, x);
                break;
            case "O":
                System.out.println("Congratulations!\nYou survived this level, please select another!");
                break;
            default:
                //aMap[y][x] = "X";
                setPosition(y, x);
                //getDirectionChoice(aMap, y, x, aPlayer);
                break;

        }
    }

    /**
     * @param y players y position on the map
     * @param x players y position on the map
     */
    private void setPosition(Integer y, Integer x) {

        aMap[prevY][prevX] = ".";
        aMap[y][x] = "X";
        showMap(aMap);
        getDirectionChoice(aMap, y, x, aPlayer);
    }

    /**
     * @param map prints out the map
     */
    public void showMap(String[][] map) {
        Integer i, j;

        System.out.print("\n\n");

        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map.length; j++)
                System.out.print(map[i][j] + "  ");
            System.out.println();
        }

        System.out.print("\n");

    }
}
