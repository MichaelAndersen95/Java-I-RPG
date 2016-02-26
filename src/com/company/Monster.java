package com.company;

import java.util.Random;

public class Monster extends Character{
    //private final String name;

    /**
     *
     * @return a random new monster
     *
     */
    public static Monster newMonster() {
        Integer i;
        Random random = new Random();
        i = random.nextInt(5);
        System.out.println(i);

        if (i == 0) {
            return new Monster("Giant Zombie Duck", 15, 3, "kicked", 4, 5);
        } else if (i == 1 || i == 2) {
            return new Monster("Demon of the Sock Drawer", 10, 2, "threw a sock at", 3, 4);
        } else {
            return new Monster("Deadly Giant Snail", 5, 1, "shot slime at", 1, 2);
        }
    }

    /**
     *
     * @param player the player is "attacked" by the monster
     */
    public void defend(Player player) {
        Integer attackPoints = attack();

        player.health = player.getHealth() - attackPoints;

        System.out.printf(" %s %s you causing %s HP damage (You have %s HP left)\n", name, attack, attackPoints, player.getHealth());

        if (player.health < 0) {
            System.out.printf("You was killed by %s\n", name);
        }
    }

    /**
     *
     * @param name monsters name
     * @param health monsters health
     * @param level monsters level
     * @param attack monsters attack
     * @param minDamage monsters minimum damage
     * @param maxDamage monsters maximum damage
     */
    private Monster(String name, Integer health, Integer level, String attack, Integer minDamage, Integer maxDamage) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.attack = attack;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

}
