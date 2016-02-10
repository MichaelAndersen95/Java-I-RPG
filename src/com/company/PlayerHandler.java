package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class PlayerHandler {

    private Player player = Player.newPlayer();

    public void playerMove(String[][] level, Integer y, Integer x) {

        Menu movementChoice = new Menu();
        movementChoice.Add("Move up", new MenuCallback() {
            public void Invoke() {
                // move north
                //player.move(level, y, x, 1);
                setPlayerPos(level, y, x, 1);
            }
        });
        movementChoice.Add("Move down", new MenuCallback() {
            public void Invoke() {
                // move south
                setPlayerPos(level, y, x, 2);
            }
        });
        movementChoice.Add("Move right", new MenuCallback() {
            public void Invoke() {
                // move east
                setPlayerPos(level, y, x, 3);
            }
        });
        movementChoice.Add("Move left", new MenuCallback() {
            public void Invoke() {
                // move west
                setPlayerPos(level, y, x, 4);
            }
        });
        movementChoice.Show();
    }

    public void setPlayerPos(String[][] level, Integer y, Integer x, Integer direction) {

        MonsterHandler monsterHandler = new MonsterHandler();

        level[y][x] = ".";

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

        switch (level[y][x]) {
            case "#":
                System.out.print("You walked into a wall, try walking another way.");

                level[currY][currX] = "X";
                showMap(level);
                playerMove(level, currY, currX);
                break;
            case "+":
                System.out.println("You ran into a monster!");

                // not working
                monsterHandler.startBattle(player);


                level[y][x] = "X";
                showMap(level);
                playerMove(level, y, x);

                break;
            case "O":
                //end of level
                System.out.println("Congratulations!\nYou survived this level, please select another!");

                // goto main menu
                break;
            default:
                level[y][x] = "X";
                showMap(level);
                playerMove(level, y, x);
                break;
        }
    }

    public void showMap(String[][] level) {
        Integer i, j;

        System.out.print("\n\n");

        for (i = 0; i < level.length; i++) {
            for (j = 0; j < level.length; j++)
                System.out.print(level[i][j] + "  ");
            System.out.println();
        }

        System.out.print("\n");

    }

}
