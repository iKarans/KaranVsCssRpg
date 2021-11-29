package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Magic fire = new Magic("Fire", 25, 600, "black");
        Magic thunder = new Magic("Thunder", 25, 600, "black");
        Magic blizzard = new Magic("Blizzard", 25, 600, "black");
        Magic meteor = new Magic("Meteor", 40, 1200, "black");
        Magic quake = new Magic("Quake", 14, 140, "black");

        Magic cure = new Magic("Cure", 25, 620, "white");
        Magic cura = new Magic("Cura", 32, 1500, "white");
        Magic curaga = new Magic("Curaga", 50, 6000, "white");

        Item potion = new Item("Potion", "potion", "Heals 50 HP", 50, 5);
        Item hipotion = new Item("Hi-Potion", "potion", "Heals 100 HP", 100, 5);
        Item superpotion = new Item("Super Potion", "potion", "Heals 1000 HP", 1000, 5);
        Item elixer = new Item("Elixer", "elixer", "Fully restores HP/MP of one party member", 9999, 5);
        Item hielixer = new Item("MegaElixer", "elixer", "Fully restores party's HP/MP", 9999, 5);

        List<Magic> heroSpells = new ArrayList<Magic>(Arrays.asList(fire, thunder, blizzard, meteor, cure, cura));
        List<Item> heroItems = new ArrayList<Item>(Arrays.asList(potion, hipotion, superpotion, elixer, hielixer));

        List<Magic> enemySpells = new ArrayList<Magic>(Arrays.asList(fire, meteor, curaga));


        Hero karan = new Hero( 3260, 132, 300, 34, "Karan", heroSpells, heroItems);
        Villain css = new Villain(18200, 701, 525, 25, "Css", enemySpells);

        List<Hero> heroes = new ArrayList<Hero>(Arrays.asList(karan));
        List<Villain> villains = new ArrayList<Villain>(Arrays.asList(css));

        karan.setEnemies(villains);
        css.setEnemies(heroes);

        boolean playing = true;
        while(playing) {
            System.out.println("Current Stats");
            for(int i = 0; i < heroes.size(); i++) {
                heroes.get(i).printInfo();
            }
            for(int i = 0; i < villains.size(); i++) {
                villains.get(i).printInfo();
            }
            for(int i = 0; i < heroes.size(); i++) {
                Hero hero = heroes.get(i);
                int choice = hero.chooseAction();
                if(choice == 1) {
                    int dmg = hero.generateDamage();
                    int enemyChoice = hero.chooseTarget() - 1;
                    Villain target = hero.getEnemies().get(enemyChoice);
                    target.takeDamage(dmg);
                    System.out.println(hero.getName() + " attacked " + target.getName() + " for " + dmg + " of damage!");
                    if(target.getHp() == 0) {
                        System.out.println(target.getName() + " has died!");
                        hero.getEnemies().remove(enemyChoice);
                    }
                } else if(choice == 2) {
                    int magicChoice = hero.chooseMagic() - 1;
                    Magic currentMagic = hero.getSpells().get(magicChoice);
                    if(currentMagic.getCost() > hero.getMp()) {
                        System.out.println("You do not have enough MP!");
                        continue;
                    }
                    int dmg = currentMagic.generateEffect();
                    if(currentMagic.getType() == "white") {
                        hero.heal(dmg);
                    } else {
                        int enemyChoice = hero.chooseTarget() - 1;
                        Villain target = hero.getEnemies().get(enemyChoice);
                        target.takeDamage(dmg);
                        System.out.println(hero.getName() + " attacked " + target.getName() + " for " + dmg + " of damage!");
                        if (target.getHp() == 0) {
                            System.out.println(target.getName() + " has died!");
                            hero.getEnemies().remove(enemyChoice);
                        }
                    }
                } else {

                }
            }
            break;
        }
    }
}
