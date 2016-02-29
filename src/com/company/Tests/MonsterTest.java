package com.company.Tests;

import com.company.Monster;
import com.company.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterTest {

    @Test
    public void testNewMonster() throws Exception {

    }

    @Test
    public void testDefend() throws Exception {
        Player player = new Player("test", 15, "punch", 2, 3);
        Monster monster = Monster.newMonster();
        Integer startHP = player.getHealth();
        monster.defend(player);
        assertNotEquals(startHP, player.getHealth());
    }

    @Test
    public void testGetName() throws Exception {
        Monster monster = Monster.newMonster();
        assertTrue(monster.getName().length() > 0);
    }
}