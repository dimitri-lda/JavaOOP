package gb;

import gb.warriors.BaseArcher;
import gb.warriors.BaseInfantry;
import gb.warriors.archers.Arbalester;
import gb.warriors.infantry.Bandit;
import gb.warriors.infantry.Pikeman;
import gb.warriors.archers.Sniper;
import gb.wizzards.Magican;
import gb.wizzards.Monk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<BaseHero> allTeams;
    public static ArrayList<BaseHero> team1;
    public static ArrayList<BaseHero> team2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        generateTeams();
        View.view();

        System.out.println("Нажмите Enter для продолжения:");
        scanner.nextLine();
        while (hasTeamsActiveWarriors()) {
            teamsMakeSteps();
            View.view();

            if (isTeamDead(team1)) {
                System.out.println("Команда синих победила!");
                break;
            } else if (isTeamDead(team2)) {
                System.out.println("Команда зеленых победила!");
                break;
            }

            System.out.println("Нажмите Enter для продолжения:");
            scanner.nextLine();
        }
    }

    private static void teamsMakeSteps() {
        for (BaseHero hero: allTeams) {
            if (team1.contains(hero)) {
                hero.step(team2, team1);
            } else {
                hero.step(team1, team2);
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
        allTeams = new ArrayList<>();
        allTeams.addAll(team1);
        allTeams.addAll(team2);
        Collections.shuffle(allTeams);
    }

    private static BaseHero getRandomHero(int heroIndex, int teamIndex) {
        int rand = new Random().nextInt(0, 7);
        int x = teamIndex == 1 ? 1 : 10;  // стартовое положение X для команды 1 и 2
        return switch (rand) {
            case 0 -> new Arbalester(randomHeroName() + String.valueOf(heroIndex), x, heroIndex);
            case 1 -> new Magican(randomHeroName() + String.valueOf(heroIndex), x, heroIndex);
            case 2 -> new Sniper(randomHeroName() + String.valueOf(heroIndex), x, heroIndex);
            case 3 -> new Monk(randomHeroName() + String.valueOf(heroIndex), x, heroIndex);
            case 4 -> new Farmer(randomHeroName() + String.valueOf(heroIndex), x, heroIndex);
            case 5 -> new Pikeman(randomHeroName() + String.valueOf(heroIndex), x, heroIndex);
            default -> new Bandit(randomHeroName() + String.valueOf(heroIndex), x, heroIndex);
        };
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

    private static boolean hasTeamsActiveWarriors() {
        for (BaseHero hero : allTeams) {
            if (hero.isDead()){
                continue;
            }
            if (hero instanceof BaseInfantry || (hero instanceof BaseArcher
                    && (((BaseArcher) hero).hasArrowsOrAliveFarmerInTeam(getTeammates(hero)))
            )) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<BaseHero> getTeammates(BaseHero hero) {
        if (team1.contains(hero)) {
            return team1;
        } else {
            return team2;
        }
    }
}