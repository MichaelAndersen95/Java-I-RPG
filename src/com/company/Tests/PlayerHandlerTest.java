package com.company.Tests;

import com.company.MapLoader;
import com.company.PlayerHandler;
import org.junit.Test;

import java.net.URL;

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
        URL url = MapLoader.class.getResource("Maps/testmap.txt");
        loadedMap = mapLoader.loadMapFromFile(url.getFile());

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