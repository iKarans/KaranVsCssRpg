package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hero extends Character {

    private List<Magic> spells;
    private List<Item> items;
    private List<String> actions = new ArrayList<String>(Arrays.asList("Attack", "Magic", "Items"));
    private List<Villain> enemies;

    public Hero(int hp, int mp, int str, int def, String name, List<Magic> spells, List<Item> items) {
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
            System.out.println(Integer.toString(i + 1) + ") " + this.getSpells().get(i).getName() + " : " + this.getSpells().get(i).getCost() + " " + this.getSpells().get(i).getDmg());
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public int chooseItem() {
        System.out.println("\n" + this.getName() + ", please choose an item");
        System.out.println("Items:");
        for (int i = 0; i < this.getItems().size(); i++) {
            System.out.println(Integer.toString(i + 1) + ") " + this.items.get(i).getName() + " : " + this.items.get(i).getDescription());
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

    public List<Item> getItems() {
        return items;
    }

    public List<Magic> getSpells() {
        return spells;
    }

    public List<Villain> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Villain> enemies) {
        this.enemies = enemies;
    }
}
