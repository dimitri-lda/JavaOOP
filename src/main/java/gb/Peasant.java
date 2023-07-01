package gb;

class Peasant extends BaseHero {

    public Peasant(String name, int hp) {
        super("Peasant_" + name, hp);
    }

    public Peasant(String name) {
        super("Peasant_" + name);
    }
}
