package gb;

import gb.warriors.Arbalester;
import gb.warriors.Bandit;
import gb.warriors.Pikeman;
import gb.warriors.Sniper;
import gb.wizzards.Magican;
import gb.wizzards.Monk;

public class Main {
    public static void main(String[] args) {
        Arbalester arbalester = new Arbalester("hero1");
        Magican magican = new Magican("hero2");
        Sniper sniper = new Sniper("hero3");
        Monk monk = new Monk("hero4");
        Peasant peasant = new Peasant("hero5");
        Pikeman pikeman = new Pikeman("hero6");
        Bandit bandit = new Bandit("hero7");

        System.out.println(arbalester.getName());
        System.out.println(magican.getName());
        System.out.println(sniper.getName());
        System.out.println(monk.getName());
        System.out.println(peasant.getName());
        System.out.println(pikeman.getName());
        System.out.println(bandit.getName());

        arbalester.attackEnemy(sniper);
        if (!sniper.isDead()) {
            System.out.println(sniper.getName() + " жив");
            monk.heal(sniper);
        }
    }
}