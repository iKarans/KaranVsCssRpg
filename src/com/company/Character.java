package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Character {
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int str;
    private int maxStr;
    private int minStr;
    private int def;
    private List<Magic> spells;
    private List<Item> items;
    private List<String> actions = new ArrayList<String>(Arrays.asList("Attack", "Magic", "Items"));
    private List<Character> enemies;
    private String name;

    public Character(int hp, int mp, int str, int def, String name, List<Magic> spells, List<Item> items, List<Character> enemies) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.mp = mp;
        this.maxMp = maxMp;
        this.str = str;
        this.maxStr = maxStr;
        this.minStr = minStr;
        this.def = def;
        this.spells = spells;
        this.items = items;
        this.enemies = enemies;
        this.name = name;
    }

    public int generateDamage() {
        return (int) Math.random() * this.maxStr + this.minStr;
    }

    public int takeDamage(int dmg) {
        this.hp -= dmg;
        if (this.hp < 0) return 0;
        return this.hp;
    }

    public void heal(int dmg) {
        this.hp += dmg;
        if (this.hp > this.maxHp) this.hp = this.maxHp;
    }

    public void reduceMp(int cost) {
        this.mp -= cost;
    }

    public int chooseAction() {
        System.out.println("\n" + this.name + ", please choose an action");
        System.out.println("Actions:");
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ") " + actions.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public int chooseMagic() {
        System.out.println("\n" + this.name + ", please choose a spell");
        System.out.println("Spells:");
        for (int i = 0; i < spells.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ") " + spells.get(i).getName());
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public int chooseItem() {
        System.out.println("\n" + this.name + ", please choose an item");
        System.out.println("Items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ") " + items.get(i).getName());
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public int chooseTarget() {
        System.out.println("\n" + this.name + ", please choose an enemy");
        System.out.println("Enemies:");
        for (int i = 0; i < enemies.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ") " + enemies.get(i).getName());
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public void printHpMpStatus() {
        String hpBar = "";
        for (int i=0; i < (this.hp / this.maxHp) * 25; i++) {
            hpBar += "█";
        }

        String mpBar = "";
        for (int j=0; j < (this.mp / this.maxMp) * 10; j++) {
            mpBar += "█";
        }

        System.out.println(Integer.toString(this.hp) + " / " + Integer.toString(this.maxHp));
        System.out.println(hpBar);
        System.out.println(Integer.toString(this.mp) + " / " + Integer.toString(this.maxMp));
        System.out.println(mpBar);
    }

    // Getters and Setters


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getMaxStr() {
        return maxStr;
    }

    public void setMaxStr(int maxStr) {
        this.maxStr = maxStr;
    }

    public int getMinStr() {
        return minStr;
    }

    public void setMinStr(int minStr) {
        this.minStr = minStr;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
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

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public List<Character> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Character> enemies) {
        this.enemies = enemies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
