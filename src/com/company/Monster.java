package com.company;

import java.util.Random;

public class Monster extends Character{
    private String name;

    public static Monster newMonster() {
        Integer i;
        Random random = new Random();
        i = random.nextInt(2);

        if (i == 0) {
            return new Monster("1", 5, 1, "punched", 1, 3);
        } else if (i == 1) {
            return new Monster("2", 10, 2, "kicked", 3, 5);
        } else {
            return new Monster("3", 15, 3, "stomped", 4, 6);
        }
    }

    public void defend(Player player) {
        Integer attackPoints = player.attack();
        hitPoints = (hitPoints > attackPoints) ? hitPoints - attackPoints : 0;
        System.out.printf(" %s %s you causing %s HP damage (%s)\n", name, attack, attackPoints, getHealth());
        if (hitPoints == 0) {
            System.out.printf("You defeated %s\n", name);
        }
    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return "Monster health: "+health;
    }

    private Monster(String name, Integer health, Integer level, String attack, Integer minDamage, Integer maxDamage) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.attack = attack;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

}
