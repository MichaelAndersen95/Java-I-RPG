package com.company;

import java.util.Random;

public class MonsterHandler {

    Monster monster = Monster.newMonster();
    //Monster monster = new Monster().newMonster();

    public void startBattle(Player player) {

        new Battle(player, monster);

    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


}
