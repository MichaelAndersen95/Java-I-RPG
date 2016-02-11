package com.company;

import java.util.Random;

public class Monster extends Character{
    private String name;

    public static Monster newMonster() {
        Integer i;
        Random random = new Random();
        i = random.nextInt(3);
        System.out.println(i);

        if (i == 0) {
            return new Monster("Deadly Giant Snail", 5, 1, "shot slime at", 1, 2);
        } else if (i == 1) {
            return new Monster("Demon of the Sock Drawer", 10, 2, "threw a sock at", 3, 4);
        } else {
            return new Monster("Giant Zombie Duck", 15, 3, "kicked", 4, 6);
        }
    }

    public void defend(Player player) {
        Integer attackPoints = attack();

        player.health = player.health - attackPoints;

        System.out.printf(" %s %s you causing %s HP damage (You have %s HP left)\n", name, attack, attackPoints, player.getHealth());

        if (player.health < 1) {
            System.out.printf("You was killed by %s\n", name);
        }
    }

    public String getName() {
        return name;
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
