package com.company;

public class Player extends Character {

    private Integer xp;
    private Integer numOfHeals = 4;

    /**
     * @param monster the monster is "attacked" by the player
     */
    public void defend(Monster monster) {
        Integer attackPoints = attack();

        monster.health = monster.health - attackPoints;

        System.out.printf(" You used %s causing %s HP damage (Monster has %s HP left)\n", attack, attackPoints, monster.getHealth());

        if (monster.health < 1) {
            System.out.printf("\nYou defeated %s (Level %s)\n", monster.getName(), monster.getLevel());
            addXP(5);
            System.out.println("You gained 5 xp, your level is now "+getLevel());
            System.out.println("You earned 1 heal from the monster");
            numOfHeals++;
        }
    }

    /**
     * @param health players health
     * @param attack players attack
     * @param level players level
     * @param maxDamage players max damage
     * @param minDamage players min damage
     * @param xp players xp
     */
    public Player(Integer health, Integer level, String attack, Integer minDamage, Integer maxDamage, Integer xp) {
        this.health = health;
        this.level = level;
        this.attack = attack;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.xp = xp;
    }

    /**
     * heals the player 7 hp if the player has any heals left
     */
    public void heal() {
        if (numOfHeals > 0) {
            health += 7;
            System.out.printf("Your health is now: %s (%s heals left)\n", health, numOfHeals);
            numOfHeals--;
        } else {
            System.out.println("You can't heal anymore");
        }
    }

    /**
     * @param newXP is added to the XP player already have
     */
    private void addXP(Integer newXP) {
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

    /**
     *
     * @return players current level
     */
    public Integer getLevel() {
        return level;
    }

}
