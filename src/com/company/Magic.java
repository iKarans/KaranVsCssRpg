package com.company;

public class Magic {
    private String name;
    private int cost;
    private int dmg;
    private String type;

    public Magic(String name, int cost, int dmg, String type) {
        this.name = name;
        this.cost = cost;
        this.dmg = dmg;
        this.type = type;
    }

    public int generateEffect() {
        return (int) (Math.random() * (15)) + this.dmg - 15;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDmg() {
        return dmg;
    }

    public String getType() {
        return type;
    }

}
