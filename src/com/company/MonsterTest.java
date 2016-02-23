package com.company;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterTest {

    @Test
    public void testNewMonster() throws Exception {

    }

    @Test
    public void testDefend() throws Exception {
        Monster monster = Monster.newMonster();
        Player player = Player.newPlayer();
        Integer startHP = player.health;
        monster.defend(player);
        assertNotEquals(startHP, player.health);
    }

    @Test
    public void testGetName() throws Exception {
        Monster monster = Monster.newMonster();
        assertTrue(monster.getName().length() > 0);
    }
}