package gb;

/**
 * Крестьянин
 */
public class Peasant extends BaseHero {
    private String type = "Peasant";

    public Peasant(String name, int hp) {
        super("Peasant_" + name, hp);
    }

    public Peasant(String name) {
        super(name);
    }

    protected String getType() {
        return this.type;
    }
}
