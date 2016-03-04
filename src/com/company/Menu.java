package com.company;

import java.util.ArrayList;
import java.util.Scanner;


class Menu {
    private final ArrayList<MenuItem> items = new ArrayList<>();
    private final UI ui = new UI();

    private class MenuItem {
        private final MenuCallback menuCallback;
        private final String text;


        public MenuItem(String text, MenuCallback menuCallback) {
            this.menuCallback = menuCallback;
            this.text = text;
        }

        public MenuCallback getMenuCallback() {
            return menuCallback;
        }

        public String getText() {
            return text;
        }
    }

    public boolean Add(String text, MenuCallback menuCallback) {
        return items.add(new MenuItem(text, menuCallback));
    }

    public void Show() {
        int chosen = 0;
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < items.size(); ++i) {
            MenuItem menuItem = items.get(i);
            ui.print(String.format("[%d] %s \n", i + 1, menuItem.getText()));
        }

        System.out.println();

        try {
            chosen = in.nextInt();
        } catch (Exception ignored) { }

        try
        {
            ui.clear();
        }
        catch (final Exception ignored) { }

        if (chosen > items.size() || chosen < 1) {
            ui.print("Invalid option.\nPress enter to continue...");
            in.nextLine();
            in.nextLine();
        } else {
            MenuItem menuItem = items.get(chosen - 1);
            MenuCallback menuCallback = menuItem.getMenuCallback();
            menuCallback.Invoke();
        }
    }
}