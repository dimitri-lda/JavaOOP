package gb;

/**
 * Крестьянин
 */
public class Peasant extends BaseHero {
    private String type = "Peasant";

    public Peasant(String name, int hp, int x, int y) {
        super("Peasant_" + name, hp, x, y);
    }

    public Peasant(String name, int x, int y) {
        super(name, x, y);
    }

    protected String getType() {
        return this.type;
    }
}
