package com.company;

class BattleHandler {

    /**
     *
     * @param player sends the player object to Battle
     * and creates a new random monster
     */
    public void startBattle(Player player) {

        Monster monster = Monster.newMonster();
        new Battle(player, monster);

    }
}
