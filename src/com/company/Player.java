package com.company;

public class Player {
    private Integer playerHealth;
    private Integer playerLevel;
    private Skill skill1;
    private Skill skill2;
    private Skill skill3;
    private Integer posX;
    private Integer posY;

    public Player(Integer pHealth, Integer pLevel, Integer posX, Integer posY) {
        this.playerHealth = pHealth;
        this.playerLevel = pLevel;
        this.posX = posX;
        this.posY = posY;
    }


}
