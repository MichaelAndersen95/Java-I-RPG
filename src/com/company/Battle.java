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

        System.out.printf("You ran into %s\n",monster.getName());
        System.out.printf("%s(%s HP) wants to fight you(%s)\n", monster.getName(), monster.getHealth(), player.getHealth());
        while (player.isAlive() && monster.isAlive()) {
            combatMenu.Show();


        }
    }

}
