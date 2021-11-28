package com.company;

import java.util.List;


public class Character {
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int str;
    private int maxStr;
    private int minStr;
    private int def;
    private String name;

    public Character(int hp, int mp, int str, int def, String name) {
        this.hp = hp;
        this.maxHp = hp;
        this.mp = mp;
        this.maxMp = mp;
        this.str = str;
        this.maxStr = str + 10;
        this.minStr = str - 10;
        this.def = def;
        this.name = name;
    }

    public int generateDamage() {
        return (int) Math.random() * (this.maxStr - this.minStr) + this.minStr;
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

    public void printInfo() {
        System.out.println(this.getName() + "          " + this.getHp() + "          " + this.getMp());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
