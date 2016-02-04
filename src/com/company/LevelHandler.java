package com.company;

public class LevelHandler {

    public void loadLevel() {

        Integer level1 [] [] = {
                { 0, 0, 2, 0, 0},
                { 0, 2, 2, 0, 0},
                { 0, 2, 0, 0, 0},
                { 0, 2, 2, 0, 0},
                { 0, 0, 1, 0, 0}
        };
        System.out.println("\n### Before ###\n");
        showMap(level1);
        changePositionTest(level1);
    }

    private void showMap(Integer[][] level) {
        Integer x, y;

        for (x = 0; x < 5; x++) {
            for (y = 0; y < 5; y++)
                System.out.print(level[x][y] + "  ");
            System.out.println();
        }
    }

    private void changePositionTest(Integer[][] level) {
        // moves player one "tile" forward
        level[3][2] = 1;
        level[4][2] = 2;
        System.out.print("\n### After ###\n");
        showMap(level);
    }

    // moves player one "tile" and updates map
    public void moveForward() {}

    public void moveBack() {}

    public void moveLeft() {}

    public void moveRight() {}

}
