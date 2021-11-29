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

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
