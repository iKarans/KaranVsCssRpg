package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Magic encapsulation = new Magic("Encapsulation", 25, 600, "black");
        Magic abstraction = new Magic("Abstraction", 35, 800, "black");
        Magic inheritance = new Magic("Inheritance", 10, 250, "black");
        Magic polymorphism = new Magic("Polymorphism", 50, 1200, "black");
        Magic oop = new Magic("OOP", 14, 140, "black");

        Magic bem = new Magic("BEM", 25, 600, "black");
        Magic uxDesign = new Magic("UX design", 35, 800, "black");
        Magic positioning = new Magic("Positioning", 50, 1200, "black");

        Item function = new Item("Function", "potion", "Heals 50 HP", 50, 5);
        Item forLoop = new Item("For Loop", "potion", "Heals 100 HP", 100, 5);
        Item whileLoop = new Item("While Loop", "potion", "Heals 1000 HP", 1000, 5);
        Item struct = new Item("Struct", "elixer", "Fully restores your HP and MP", 9999, 2);
        Item object = new Item("Object", "elixer", "Fully restores party's HP/MP", 9999, 1);

        List<Magic> heroSpells = new ArrayList<Magic>(Arrays.asList(encapsulation, abstraction, inheritance, polymorphism, oop));
        List<Item> heroItems = new ArrayList<Item>(Arrays.asList(function, forLoop, whileLoop, struct, object));

        List<Magic> enemySpells = new ArrayList<Magic>(Arrays.asList(bem, uxDesign, positioning));


        Hero karan = new Hero( 4160, 188, 311, 34, "Karan", heroSpells, heroItems);
        Hero cpp = new Hero( 3260, 132, 300, 34, "C++", heroSpells, heroItems);
        Hero java = new Hero( 3089, 174, 288, 34, "java", heroSpells, heroItems);

        Villain css = new Villain(18200, 701, 525, 25, "Css", enemySpells);
        Villain scss = new Villain(1250, 130, 560, 325, "Scss", enemySpells);
        Villain figma = new Villain(1250, 130, 560, 325, "Figma", enemySpells);

        List<Hero> heroes = new ArrayList<Hero>(Arrays.asList(karan, cpp, java));
        List<Villain> villains = new ArrayList<Villain>(Arrays.asList(css, scss, figma));

        karan.setEnemies(villains);
        cpp.setEnemies(villains);
        java.setEnemies(villains);

        css.setEnemies(heroes);
        scss.setEnemies(heroes);
        figma.setEnemies(heroes);

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
                    int enemyChoice = hero.chooseTarget() - 1;
                    Villain target = hero.getEnemies().get(enemyChoice);
                    target.takeDamage(dmg);
                    System.out.println(hero.getName() + " attacked " + target.getName() + " for " + dmg + " of damage!");
                    if (target.getHp() == 0) {
                        System.out.println(target.getName() + " has died!");
                        hero.getEnemies().remove(enemyChoice);
                    }

                    hero.setMp(hero.getMp() - currentMagic.getCost());
                } else {
                    int itemChoice = hero.chooseItem() - 1;
                    Item currentItem = hero.getItems().get(itemChoice);
                    if(currentItem.getQuantity() == 0) {
                        System.out.println("You do not have enough quantity");
                        continue;
                    }
                    currentItem.setQuantity(currentItem.getQuantity() - 1);
                    if(currentItem.getType() == "potion") {
                        hero.heal(currentItem.getProp());
                    } else if(currentItem.getType() == "elixer") {
                        if(currentItem.getName() == "Object") {
                            for(int j = 0; j < heroes.size(); j++) {
                                heroes.get(j).setHp(heroes.get(j).getMaxHp());
                                heroes.get(j).setMp(heroes.get(j).getMaxMp());
                            }
                        } else {
                            hero.setHp(heroes.get(i).getMaxHp());
                            hero.setMp(heroes.get(i).getMaxMp());
                        }
                    } else if(currentItem.getType() == "attack") {
                        int enemyChoice = hero.chooseTarget() - 1;
                        Villain target = hero.getEnemies().get(enemyChoice);
                        target.takeDamage(currentItem.getProp());
                        System.out.println(hero.getName() + " attacked " + target.getName() + " for " + currentItem.getProp() + " of damage!");
                        if (target.getHp() == 0) {
                            System.out.println(target.getName() + " has died!");
                            hero.getEnemies().remove(enemyChoice);
                        }
                    }
                }
                if(villains.size() == 0) return;
            }
            System.out.println("Enemies preparing to attack...");
            for(int i = 0; i < villains.size(); i++) {
                Villain villain = villains.get(i);
                int actionChoice = (int) Math.floor(Math.random() * villain.getActions().size());
                int heroTargetIndex = (int) Math.floor(Math.random() * villain.getEnemies().size());
                Hero heroTarget = villain.getEnemies().get(heroTargetIndex);
                if(actionChoice == 0) {
                    int dmg = villain.generateDamage();
                    heroTarget.takeDamage(dmg);
                    System.out.println(villain.getName() + " attacked " + heroTarget.getName() + " for " + dmg +" of damage!");
                } else if(actionChoice == 1) {
                    Magic spell = villain.getSpells().get((int) Math.floor(Math.random() * villain.getSpells().size()));
                    if(spell.getType() == "white") {
                        int dmg = spell.generateEffect();
                        villain.heal(dmg);
                        System.out.println(spell.getName() + " heals " + villain.getName() + " for " + dmg + " HP!");
                    } else if(spell.getType() == "black") {
                        int dmg = spell.generateEffect();
                        heroTarget.takeDamage(dmg);
                        System.out.println(villain.getName() + " attacked " + heroTarget.getName() + " for " + dmg + " of damage!");
                    }
                    villain.setMp(villain.getMaxMp() - spell.getCost() );
                    }
                if (heroTarget.getHp() == 0) {
                    System.out.println(heroTarget.getName() + " has died!");
                    villain.getEnemies().remove(heroTargetIndex);
                }
                if(heroes.size() == 0) return;
            }
        }
    }
}
