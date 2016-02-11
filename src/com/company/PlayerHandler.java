package com.company;

public class PlayerHandler {

    private Player player = Player.newPlayer();

    public void playerMove(String[][] map, Integer y, Integer x) {

        Menu movementChoice = new Menu();
        movementChoice.Add("Move up", new MenuCallback() {
            public void Invoke() {
                setPlayerPos(map, y, x, 1);
            }
        });
        movementChoice.Add("Move down", new MenuCallback() {
            public void Invoke() {
                setPlayerPos(map, y, x, 2);
            }
        });
        movementChoice.Add("Move right", new MenuCallback() {
            public void Invoke() {
                setPlayerPos(map, y, x, 3);
            }
        });
        movementChoice.Add("Move left", new MenuCallback() {
            public void Invoke() {
                setPlayerPos(map, y, x, 4);
            }
        });
        movementChoice.Show();
    }

    public void setPlayerPos(String[][] map, Integer y, Integer x, Integer direction) {

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

        switch (map[y][x]) {
            case "#":
                System.out.print("You walked into a wall, try walking another way.");

                map[currY][currX] = "X";
                showMap(map);
                playerMove(map, currY, currX);
                break;
            case "+":
                battleHandler.startBattle(player);

                map[y][x] = "X";
                showMap(map);
                playerMove(map, y, x);

                break;
            case "O":
                //end of level
                System.out.println("Congratulations!\nYou survived this level, please select another!");

                // goto main menu
                break;
            default:
                map[y][x] = "X";
                showMap(map);
                playerMove(map, y, x);
                break;
        }
    }

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
