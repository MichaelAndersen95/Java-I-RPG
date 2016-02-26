package com.company;

import java.util.Random;

public class Character {
    String name;
    Integer health;
    Integer level;
    String attack;
    Integer minDamage;
    Integer maxDamage;
    private final Random random = new Random();

    /**
     * @return amount of hp the damage between the objects minimum and maximum damage
     */
    public Integer attack() {
        return random.nextInt(maxDamage - minDamage + 1) + minDamage;
    }

    /**
     * @return true if the object is alive or false if dead
     */
    public Boolean isAlive() {
        return health > 0;
    }

    /**
     * @return objects HP
     */
    public Integer getHealth() {
        return health;
    }

    /**
     * @return objects level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @return objects name
     */
    public String getName() {
        return name;
    }
}
