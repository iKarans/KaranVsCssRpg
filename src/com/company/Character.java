package com.company;

import java.util.ArrayList;
import java.util.Arrays;
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
    private List<Magic> spells;
    private List<Items> items;
    private List<String> actions = new ArrayList<String>(Arrays.asList("Attack", "Magic", "Items"));
    private String name;

    public Character(int hp, int mp, int str, int def, String name, List<Magic> spells, List<Items> items) {
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
        this.name = name;
    }
}
