package gb;

import gb.warriors.archers.Arbalester;
import gb.warriors.Bandit;
import gb.warriors.Pikeman;
import gb.warriors.archers.Sniper;
import gb.wizzards.Magican;
import gb.wizzards.Monk;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<BaseHero> allTeam;
    public static ArrayList<BaseHero> team1;
    public static ArrayList<BaseHero> team2;
    public static void main(String[] args) {
        generateTeams();

        View.view();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            scanner.nextLine();
            System.out.println("Ходит Команда 1:");
            team1.forEach(hero -> hero.step(team2, team1));

            System.out.println("\rХодит Команда 2:");
            team2.forEach(hero -> hero.step(team1, team2));

            View.view();
            if (isTeamDead(team1)) {
                System.out.println("Команда 2 победила!");
                break;
            } else if (isTeamDead(team2)) {
                System.out.println("Команда 1 победила!");
                break;
            }
        }
    }

    private static void generateTeams() {
        team1 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            team1.add(getRandomHero(i, 1));
        }
        team2 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            team2.add(getRandomHero(i, 2));
        }
        allTeam = new ArrayList<>();
        allTeam.addAll(team1);
        allTeam.addAll(team2);
    }

    private static BaseHero getRandomHero(int heroIndex, int teamIndex) {
        int rand = new Random().nextInt(0, 7);
        int x = heroIndex;
        int y = teamIndex == 1 ? 1 : 10;  // стартовое положение Y для команды 1 и 2
        switch (rand) {
            case 0:
                return new Arbalester(randomHeroName() + "_" + teamIndex + heroIndex, x, y);
            case 1:
                return new Magican(randomHeroName() + "_" + teamIndex + heroIndex, x, y);
            case 2:
                return new Sniper(randomHeroName() + "_" + teamIndex + heroIndex, x, y);
            case 3:
                return new Monk(randomHeroName() + "_" + teamIndex + heroIndex, x, y);
            case 4:
                return new Farmer(randomHeroName() + "_" + teamIndex + heroIndex, x, y);
            case 5:
                return new Pikeman(randomHeroName() + "_" + teamIndex + heroIndex, x, y);
            case 6:
            default:
                return new Bandit(randomHeroName() + "_" + teamIndex + heroIndex, x, y);
        }
    }

    private static HeroNames randomHeroName() {
        int pick = new Random().nextInt(HeroNames.values().length);
        return HeroNames.values()[pick];
    }

    private static boolean isTeamDead(ArrayList<BaseHero> team) {
        for (BaseHero hero : team) {
            if (!hero.isDead()) {
                return false;
            }
        }
        return true;
    }
}