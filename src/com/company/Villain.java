package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Villain extends Character {
    private List<Magic> spells;
    private List<String> actions = new ArrayList<String>(Arrays.asList("Attack", "Magic"));
    private List<Hero> enemies;

    public Villain(int hp, int mp, int str, int def, String name, List<Magic> spells) {
        super(hp, mp, str, def, name);
        this.spells = spells;
    }

    public int chooseAction() {
        System.out.println("\n" + this.getName()+ ", please choose an action");
        System.out.println("Actions:");
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ") " + actions.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public int chooseMagic() {
        System.out.println("\n" + this.getName() + ", please choose a spell");
        System.out.println("Spells:");
        for (int i = 0; i < this.getSpells().size(); i++) {
            System.out.println(Integer.toString(i + 1) + ") " + this.getSpells().get(i).getName());
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public int chooseTarget() {
        System.out.println("\n" + this.getName() + ", please choose an enemy");
        System.out.println("Enemies:");
        for (int i = 0; i < enemies.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ") " + enemies.get(i).getName());
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public List<Magic> getSpells() {
        return spells;
    }

    public List<Hero> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Hero> enemies) {
        this.enemies = enemies;
    }
}
