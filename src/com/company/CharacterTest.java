package com.company;

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
        Player player = Player.newPlayer();
        assertTrue(player.isAlive());
        player.health = 0;
        assertFalse(player.isAlive());
    }

    @Test
    public void testGetHealth() throws Exception {
        Player player = Player.newPlayer();
        Integer expected = 15;
        assertEquals(expected, player.getHealth());
    }

    @Test
    public void testGetLevel() throws Exception {
        Player player = Player.newPlayer();
        Integer expected = 1;
        assertEquals(expected, player.getLevel());
    }
}