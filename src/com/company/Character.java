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
    private List<Magic> Spells;
    private List<Items> items;
    private List<String> actions = new ArrayList<String>(Arrays.asList("Attack", "Magic", "Items"));
    private String name;

}
