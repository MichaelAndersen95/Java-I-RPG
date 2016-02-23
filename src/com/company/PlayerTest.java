package com.company;

import static org.junit.Assert.*;

public class PlayerTest {

    @org.junit.Test
    public void testNewPlayer() throws Exception {

    }

    @org.junit.Test
    public void testDefend() throws Exception {
        Player player = Player.newPlayer();
        Monster monster = Monster.newMonster();
        Integer startHP = monster.health;
        player.defend(monster);
        assertNotEquals(startHP, monster.health);
    }

    @org.junit.Test
    public void testHeal() throws Exception {
        Player player = Player.newPlayer();
        Integer expected = 22;
        player.heal();
        assertEquals(expected, player.health);
    }

    @org.junit.Test
    public void testGetLevel() throws Exception {
        Player player = Player.newPlayer();
        assertEquals(1, player.getLevel(), 0);
    }
}