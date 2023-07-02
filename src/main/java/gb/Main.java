package gb;

import gb.warriors.Arbalester;
import gb.warriors.Bandit;
import gb.warriors.Pikeman;
import gb.warriors.Sniper;
import gb.wizzards.Magican;
import gb.wizzards.Monk;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Arbalester arbalester = new Arbalester("hero1");
//        Magican magican = new Magican("hero2");
//        Sniper sniper = new Sniper("hero3");
//        Monk monk = new Monk("hero4");
//        Peasant peasant = new Peasant("hero5");
//        Pikeman pikeman = new Pikeman("hero6");
//        Bandit bandit = new Bandit("hero7");
//
//        System.out.println(arbalester.getName());
//        System.out.println(magican.getName());
//        System.out.println(sniper.getName());
//        System.out.println(monk.getName());
//        System.out.println(peasant.getName());
//        System.out.println(pikeman.getName());
//        System.out.println(bandit.getName());
//
//        arbalester.attackEnemy(sniper);
//        System.out.println(sniper.getInfo());
//        if (!sniper.isDead()) {
//            monk.heal(sniper);
//            System.out.println(sniper.getInfo());
//        }

        ArrayList<BaseHero> team1 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            team1.add(getRandomHero(i));
        }

        ArrayList<BaseHero> team2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            team2.add(getRandomHero(i));
        }
    }

    private static BaseHero getRandomHero(int index) {
        int rand = new Random().nextInt(0, 7);
        switch (rand) {
            case 0:
                return new Arbalester(randomHeroName() + " " + index);
            case 1:
                return new Magican(randomHeroName() + " " + index);
            case 2:
                return new Sniper(randomHeroName() + " " + index);
            case 3:
                return new Monk(randomHeroName() + " " + index);
            case 4:
                return new Peasant(randomHeroName() + " " + index);
            case 5:
                return new Pikeman(randomHeroName() + " " + index);
            case 6:
            default:
                return new Bandit(randomHeroName() + " " + index);
        }
    }

    private static HeroNames randomHeroName() {
        int pick = new Random().nextInt(HeroNames.values().length);
        return HeroNames.values()[pick];
    }
}