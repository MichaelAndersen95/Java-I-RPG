package com.company;

public class Player extends Character {

    private Integer xp;

    private Integer numOfHeals = 4;

    public static Player newPlayer() {
        return new Player(10, 1, "punch", 2, 3, 0);
    }

    public void defend(Monster monster) {
        Integer attackPoints = attack();

        monster.health = monster.health - attackPoints;

        System.out.printf(" You used %s causing %s HP damage (Monster has %s HP left)\n", attack, attackPoints, monster.getHealth());

        if (monster.health < 1) {
            System.out.printf("\nYou defeated %s (Level %s)\n", monster.getName(), monster.getLevel());
            addXP(5);
            System.out.println("You gained 5 xp, your level is now "+getLevel());
        }

    }

    private Player(Integer health, Integer level, String attack, Integer minDamage, Integer maxDamage, Integer xp) {
        this.health = health;
        this.level = level;
        this.attack = attack;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.xp = xp;
    }

    @Override
    public Boolean isAlive() {
        return health > 0;
    }

    public void heal() {
        if (numOfHeals > 0) {
            health += 5;
            System.out.printf("Your health is now: %s (%s heals left)\n", health, numOfHeals);
            numOfHeals--;
        } else {
            System.out.println("You can't heal anymore");
        }
    }

    public Integer getXP() {
        return xp;
    }

    public void addXP(Integer newXP) {
        xp = xp + newXP;

        switch (xp) {
            case 5:
                level = 1;
                break;
            case 10:
                level = 2;
                break;
            case 15:
                level = 3;
                break;
            case 20:
                level = 4;
                break;
            case 30:
                level = 5;
                break;
            case 40:
                level = 6;
                break;
            case 50:
                level = 7;
                break;
            default:
                level = 0;
                break;
        }
    }

    public Integer getLevel() {
        return level;
    }

}
