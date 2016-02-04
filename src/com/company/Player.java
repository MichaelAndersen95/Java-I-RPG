package com.company;

public class Player {
    private Integer playerHealth;
    private Integer playerLevel;
    private Skill skill1;
    private Skill skill2;
    private Skill skill3;

    public Player(Integer pHealth, Integer pLevel) {
        this.playerHealth = pHealth;
        this.playerLevel = pLevel;
    }

    public void playerLeveledUp(Integer playerLevel) {
        this.playerLevel = playerLevel + 1;
        this.playerHealth += 5;
    }

}
