package com.company;

import java.util.Random;

public class Character {
    public Integer health;
    public Integer hitPoints;
    public Integer level;
    public String attack;
    public Integer minDamage;
    public Integer maxDamage;
    public Random random = new Random();

    public Integer attack() {
        return random.nextInt(maxDamage - minDamage + 1) + minDamage;
    }

    public Boolean isAlive() {
        return null;
    }



}
