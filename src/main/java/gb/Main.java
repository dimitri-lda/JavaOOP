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
        ArrayList<BaseHero> team1 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            team1.add(getRandomHero(i));
        }
        ArrayList<BaseHero> team2 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            team2.add(getRandomHero(i));
        }

        System.out.println("Команда 1:");
        team1.forEach(hero -> System.out.println(hero.getInfo()));

        System.out.println("\nКоманда 2:");
        team2.forEach(hero -> System.out.println(hero.getInfo()));
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