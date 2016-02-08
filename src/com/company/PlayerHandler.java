package com.company;

public class PlayerHandler {

    //LevelHandler levelHandler = new LevelHandler();
    Integer x = 2;
    Integer y = 4;

    public void playerMove(String[][] level, Integer y, Integer x) {

        //levelHandler.showMap(level);

        Menu movementChoice = new Menu();
        movementChoice.Add("Move north", new MenuCallback() {
            public void Invoke() {
                // move north
                movePlayer(level, y, x, 1);
            }
        });
        movementChoice.Add("Move south", new MenuCallback() {
            public void Invoke() {
                // move south
                movePlayer(level, y, x, 2);
            }
        });
        movementChoice.Add("Move east", new MenuCallback() {
            public void Invoke() {
                // move east
                movePlayer(level, y, x, 3);
            }
        });
        movementChoice.Add("Move west", new MenuCallback() {
            public void Invoke() {
                // move west
                movePlayer(level, y, x, 4);
            }
        });
        movementChoice.Show();
    }

    public void movePlayer(String[][] level, Integer y, Integer x, Integer direction) {

        level[y][x] = ".";

        System.out.print(direction);

        switch (direction) {
            case 1 :
                y--;
                break;
            case 2 :
                y++;
                break;
            case 3 :
                x--;
                break;
            case 4 :
                x++;
                break;
            default :
                System.exit(1);
                break;
        }

        level[y][x] = "X";

        showMap(level);
        playerMove(level, y, x);

    }

    public void showMap(String[][] level) {
        Integer i, j;

        System.out.print("\n\n");

        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++)
                System.out.print(level[i][j] + "  ");
            System.out.println();
        }

        System.out.print("\n");

    }

}
