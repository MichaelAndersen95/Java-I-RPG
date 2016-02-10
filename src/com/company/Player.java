package com.company;

public class Player extends Character {

    private Integer numOfHeals = 5;
    private Integer maxHealth = 20;

    public static Player newPlayer() {
        return new Player(10, 1, "punch", 3, 4);
    }

    public void defend(Monster monster) {
        Integer attackPoints = monster.attack();
        hitPoints = (hitPoints > attackPoints) ? hitPoints - attackPoints : 0;
        System.out.printf(" You used %s causing %s HP damage (%s)\n", attack, attackPoints, getHealth());
        if (hitPoints == 0) {
            System.out.printf("You was killed by %s\n", monster.getName());
        }
    }

    public String getHealth() {
        return "Player health: "+health;
    }

    private Player(Integer health, Integer level, String attack, Integer minDamage, Integer maxDamage) {
        this.health = health;
        this.level = level;
        this.attack = attack;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public void heal() {
        if (numOfHeals > 0) {
            health = Math.min(maxHealth, hitPoints + 5);
            System.out.printf("Your health is now: %s (%s heals left)\n", getHealth(), numOfHeals);
            numOfHeals--;
        } else {
            System.out.println("You can't heal anymore");
        }
    }
}
