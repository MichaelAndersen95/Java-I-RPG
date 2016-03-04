package com.company;

public class Player extends Character {

    private Integer xp;
    private Integer numOfHeals = 4;
    private Integer kills = 0;
    private final UI ui = new UI();

    /**
     * @param monster the monster is "attacked" by the player
     */
    public void defend(Monster monster) {
        Integer attackPoints = attack();
        monster.health = monster.health - attackPoints;

        ui.print(String.format(" You used %s causing %s HP damage (Monster has %s HP left)\n", attack, attackPoints,
                monster.getHealth()));

        if (monster.health < 1) {
            ui.clear();
            ui.print(String.format("\nYou defeated %s (Level %s)\n", monster.getName(), monster.getLevel()));
            addXP(5);
            addKill();
            ui.print("You gained 5 xp, your level is now "+getLevel()+"\nYou earned 1 heal from the monster\n\n");
            numOfHeals++;
        }
    }

    /**
     * @param health players health
     * @param attack players attack
     * @param maxDamage players max damage
     * @param minDamage players min damage
     */
    public Player(String name, Integer health, String attack, Integer minDamage, Integer maxDamage) {
        this.name = name;
        this.health = health;
        this.level = 1;
        this.attack = attack;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.xp = 0;
    }

    /**
     * heals the player 7 hp if the player has any heals left
     */
    public void heal() {
        if (numOfHeals > 0) {
            health += 7;
            ui.print(String.format("Your health is now: %s (%s heals left)\n", health, numOfHeals));
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
                ui.print("You have reached max level");
                break;
            default:
                level = 0;
                break;
        }
    }

    public Integer getScore() {
        return level * xp;
    }

    private void addKill() {
        kills++;
    }

    public Integer getKills() {
        return kills;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
