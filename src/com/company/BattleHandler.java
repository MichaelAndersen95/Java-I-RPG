package com.company;

public class BattleHandler {

    public void startBattle(Player player) {

        Monster monster = Monster.newMonster();
        new Battle(player, monster);

    }
}
