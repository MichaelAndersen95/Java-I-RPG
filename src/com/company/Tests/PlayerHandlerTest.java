package com.company.Tests;

import com.company.MapLoader;
import com.company.PlayerHandler;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerHandlerTest {

    @Test
    public void testMoveUp() throws Exception {
        PlayerHandler playerHandler = new PlayerHandler();
        int y = playerHandler.moveUp(6);
        assertEquals(5, y);
    }

    @Test
    public void testMoveDown() throws Exception {
        PlayerHandler playerHandler = new PlayerHandler();
        int y = playerHandler.moveDown(6);
        assertEquals(7, y);
    }

    @Test
    public void testMoveRight() throws Exception {
        PlayerHandler playerHandler = new PlayerHandler();
        int x = playerHandler.moveRight(3);
        assertEquals(4, x);
    }

    @Test
    public void testMoveLeft() throws Exception {
        PlayerHandler playerHandler = new PlayerHandler();
        int x = playerHandler.moveLeft(3);
        assertEquals(2, x);
    }

    @Test
    public void testShowMap() throws Exception {
        MapLoader mapLoader = new MapLoader();
        String[][] loadedMap;
        //TODO make this load without full path
        loadedMap = mapLoader.loadMapFromFile("/home/michtheturtle/ownCloud/Skole/Programmering/Java-I-RPG/out/production/Java-I-RPG/com/company/Maps/testmap.txt");

        String[][] testingMap = new String[][]{
                { "#", "#", "#", "O", "#", "#", "#", "#" },
                { "#", "#", "#", ".", "#", "#", "#", "#" },
                { "#", "#", "#", ".", "#", "#", "#", "#" },
                { "#", "#", "#", "+", "#", "#", "#", "#" },
                { "#", "#", "#", ".", "#", "#", "#", "#" },
                { "#", "#", "#", ".", "#", "#", "#", "#" },
                { "#", "#", ".", "X", ".", "#", "#", "#" },
                { "#", "#", "#", ".", "#", "#", "#", "#" }
        };


        assertArrayEquals(testingMap, loadedMap);
    }
}