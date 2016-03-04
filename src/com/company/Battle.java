package com.company;

class Battle {

    public Battle(Player player, Monster monster) {
        UI ui = new UI();
        Menu combatMenu = new Menu();

        combatMenu.Add("Attack", () -> {
            monster.defend(player);
            if (monster.isAlive()) {
                player.defend(monster);
            }
        });
        combatMenu.Add("Heal", player::heal);

        ui.clear();
        ui.print(String.format("You ran into  %s (Level %s)\n", monster.getName(), monster.getLevel()));
        ui.print(String.format("%s(%s HP) wants to fight you(%s HP, Level %s)\n\n", monster.getName(),
                monster.getHealth(), player.getHealth(), player.getLevel()));

        while (player.isAlive() && monster.isAlive()) {
            combatMenu.Show();
        }
    }

}
