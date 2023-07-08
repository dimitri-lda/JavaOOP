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
            team1.add(getRandomHero(i, 1));
        }
        ArrayList<BaseHero> team2 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            team2.add(getRandomHero(i, 2));
        }

        System.out.println("Команда 1:");
        team1.forEach(hero -> {
            System.out.println(hero.getInfo());
            showClosestEnemy(hero, team2);
            System.out.println();
        });

        System.out.println("\nКоманда 2:");
        team2.forEach(hero -> {
            System.out.println(hero.getInfo());
            showClosestEnemy(hero, team1);
            System.out.println();
        });
    }

    private static BaseHero getRandomHero(int heroIndex, int teamIndex) {
        int rand = new Random().nextInt(0, 7);
        int x = new Random().nextInt(0, 10);
        int y = new Random().nextInt(0, 10);
        x = teamIndex == 1 ? x : x + 15;  // 15 - смещение по оси X для второй команды
        switch (rand) {
            case 0:
                return new Arbalester(randomHeroName() + " " + teamIndex + heroIndex, x, y);
            case 1:
                return new Magican(randomHeroName() + " " + teamIndex + heroIndex, x, y);
            case 2:
                return new Sniper(randomHeroName() + " " + teamIndex + heroIndex, x, y);
            case 3:
                return new Monk(randomHeroName() + " " + teamIndex + heroIndex, x, y);
            case 4:
                return new Peasant(randomHeroName() + " " + teamIndex + heroIndex, x, y);
            case 5:
                return new Pikeman(randomHeroName() + " " + teamIndex + heroIndex, x, y);
            case 6:
            default:
                return new Bandit(randomHeroName() + " " + teamIndex + heroIndex, x, y);
        }
    }

    private static HeroNames randomHeroName() {
        int pick = new Random().nextInt(HeroNames.values().length);
        return HeroNames.values()[pick];
    }

    private static void showClosestEnemy(BaseHero hero, ArrayList<BaseHero> enemies) {
        BaseHero closestEnemy = null;
        double closestDistance = 0;
        for (BaseHero enemy : enemies) {
            double distance = Math.sqrt(Math.pow(hero.getCoordinates().getX() - enemy.getCoordinates().getX(), 2)
                            + Math.pow(hero.getCoordinates().getY() - enemy.getCoordinates().getY(), 2));
            if (closestEnemy == null || distance < closestDistance) {
                closestEnemy = enemy;
                closestDistance = distance;
            }
        }
        if (closestEnemy != null)
            System.out.printf("Ближайший противник: %s, расстояние: %.2f\n", closestEnemy.getName(), closestDistance);
    }
}