package gb;

class Monk extends BaseHero {

    public Monk(String name, int hp) {
        super("Monk_" + name, hp);
    }

    public Monk(String name) {
        super("Monk_" + name);
    }
}
