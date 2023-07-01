package gb;

public class Main {
    public static void main(String[] args) {
        Arbalester arbalester = new Arbalester("hero1");
        Magican magican = new Magican("hero2");
        Sniper sniper = new Sniper("hero3");
        Monk monk = new Monk("hero4");
        Peasant peasant = new Peasant("hero5");
        Pikeman pikeman = new Pikeman("hero6");
        Robber robber = new Robber("hero7");

        System.out.println(arbalester.getName());
        System.out.println(magican.getName());
        System.out.println(sniper.getName());
        System.out.println(monk.getName());
        System.out.println(peasant.getName());
        System.out.println(pikeman.getName());
        System.out.println(robber.getName());
    }
}