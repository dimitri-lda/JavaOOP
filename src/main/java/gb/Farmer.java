package gb;

/**
 * Крестьянин
 */
public class Farmer extends BaseHero {
    private String type = "Farmer";

    public Farmer(String name, int hp, int x, int y) {
        super("Farmer_" + name, hp, x, y);
    }

    public Farmer(String name, int x, int y) {
        super(name, x, y);
    }

    protected String getType() {
        return this.type;
    }
}
