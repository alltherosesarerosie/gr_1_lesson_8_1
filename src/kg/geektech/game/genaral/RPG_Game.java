package kg.geektech.game.genaral;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    static int roundNumber;

    public static int getRoundNumber() {
        return roundNumber;
    }


    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(1500, 50, "Rahim");
        Warrior warrior = new Warrior(290, 10, "Tilek");
        Medic doc = new Medic(250, 5, 15, "Aziret");
        Magic magic = new Magic(280, 20, "Aigerim");
        Berserk berserk = new Berserk(270, 15, "Sanjar");
        Medic junior = new Medic(260, 5, 5, "Jun");
        Golem golem = new Golem(550,5,"golem");

//        ------------

        Witcher witcher = new Witcher(300,0, "witcher");
        Hacker hacker = new Hacker(220, 15,"hacker");
        Hero[] heroes = {warrior, doc, magic, berserk, junior,golem, witcher, hacker};

//        --------------

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 &&
                    boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }
}
