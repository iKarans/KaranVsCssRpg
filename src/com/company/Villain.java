package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Villain extends Character {
    private List<Magic> spells;
    private List<Item> items;
    private List<String> actions = new ArrayList<String>(Arrays.asList("Attack", "Magic"));
    private List<Character> enemies;

    public Villain(int hp, int mp, int str, int def, String name, List<Magic> spells, List<Item> items) {
        super(hp, mp, str, def, name);
        this.spells = spells;
        this.items = items;
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

    public void setSpells(List<Magic> spells) {
        this.spells = spells;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Character> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Character> enemies) {
        this.enemies = enemies;
    }
}
