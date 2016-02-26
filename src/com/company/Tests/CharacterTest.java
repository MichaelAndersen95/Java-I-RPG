package com.company.Tests;

import com.company.Monster;
import com.company.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    @Test
    public void testAttack() throws Exception {
        Monster monster = Monster.newMonster();
        Integer i = monster.attack();
        assertTrue(i > 0 && i < 6);
    }

    @Test
    public void testIsAlive() throws Exception {
        Player player = new Player("test", 15, 1, "punch", 2, 3, 1);
        assertTrue(player.isAlive());
        player.setHealth(0);
        assertFalse(player.isAlive());
    }

    @Test
    public void testGetHealth() throws Exception {
        Player player = new Player("test", 15, 1, "punch", 2, 3, 1);
        Integer expected = 15;
        assertEquals(expected, player.getHealth());
    }

    @Test
    public void testGetLevel() throws Exception {
        Player player = new Player("test", 15, 1, "punch", 2, 3, 1);
        Integer expected = 1;
        assertEquals(expected, player.getLevel());
    }
}