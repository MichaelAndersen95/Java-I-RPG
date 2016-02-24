package com.company.Tests;

import com.company.Monster;
import com.company.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testDefend() throws Exception {
        Monster monster = Monster.newMonster();
        Player player = new Player(15, 1, "punch", 2, 3, 1);
        Integer startHP = monster.health;
        player.defend(monster);
        assertNotEquals(startHP, monster.health);
    }

    @org.junit.Test
    public void testHeal() throws Exception {
        Player player = new Player(15, 1, "punch", 2, 3, 1);
        Integer expected = 22;
        player.heal();
        assertEquals(expected, player.health);
    }

    @org.junit.Test
    public void testGetLevel() throws Exception {
        Player player = new Player(15, 1, "punch", 2, 3, 1);
        assertEquals(1, player.getLevel(), 0);
    }
}