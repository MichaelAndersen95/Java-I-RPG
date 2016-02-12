package com.company;

class PlayerHandler {

    /**
     * Moves the player around the map
     * @param map the map to move the player in
     * @param y y position
     * @param x x position
     * @param player the player object
     */
    public void playerMove(String[][] map, Integer y, Integer x, Player player) {

        if (player.isAlive()) {
            Menu movementChoice = new Menu();
            movementChoice.Add("Move up", () -> setPosition(map, y, x, 1, player));
            movementChoice.Add("Move down", () -> setPosition(map, y, x, 2, player));
            movementChoice.Add("Move right", () -> setPosition(map, y, x, 3, player));
            movementChoice.Add("Move left", () -> setPosition(map, y, x, 4, player));
            movementChoice.Show();
        } else {
            System.out.println("Looks like you died, better luck next time.\n\n");
            System.exit(0);
        }
    }

    /**
     *
     * @param map the map to set position in
     * @param y players y position on the map
     * @param x players y position on the map
     * @param direction the direction the player wants to go, up, down, left or right
     * @param player the player object to be moved
     */
    private void setPosition(String[][] map, Integer y, Integer x, Integer direction, Player player) {

        BattleHandler battleHandler = new BattleHandler();

        map[y][x] = ".";

        Integer currX = x;
        Integer currY = y;

        switch (direction) {
            case 1:
                y--;
                break;
            case 2:
                y++;
                break;
            case 3:
                x++;
                break;
            case 4:
                x--;
                break;
            default:
                System.exit(1);
                break;
        }

        /**
         * Checks if the direction the player wants to go is possible
         */
        switch (map[y][x]) {
            case "#":
                System.out.print("You walked into a wall, try walking another way.");

                map[currY][currX] = "X";
                showMap(map);
                playerMove(map, currY, currX, player);
                break;
            case "+":
                battleHandler.startBattle(player);

                map[y][x] = "X";
                showMap(map);
                playerMove(map, y, x, player);

                break;
            case "O":
                System.out.println("Congratulations!\nYou survived this level, please select another!");

                break;
            default:
                map[y][x] = "X";
                showMap(map);
                playerMove(map, y, x, player);
                break;
        }
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
