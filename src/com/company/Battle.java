package com.company;

public class Battle {

    public Battle(Player player, Monster monster) {

        Menu combatMenu = new Menu();

        combatMenu.Add("Attack", new MenuCallback() {
            public void Invoke() {
                monster.defend(player);
                if (monster.isAlive()) {
                    player.defend(monster);
                }
            }
        });
        combatMenu.Add("Heal", new MenuCallback() {
            public void Invoke() {
                player.heal();
            }
        });
        combatMenu.Add("Main menu / Quit", new MenuCallback() {
            public void Invoke() {
                //main menu
                System.exit(0);
            }
        });

        System.out.printf("You ran into  %s (Level %s)\n", monster.getName(), monster.getLevel());
        System.out.printf("%s(%s HP) wants to fight you(%s HP, Level %s)\n\n", monster.getName(), monster.getHealth(), player.getHealth(), player.getLevel());
        while (player.isAlive() && monster.isAlive()) {
            combatMenu.Show();
        }
    }

}
