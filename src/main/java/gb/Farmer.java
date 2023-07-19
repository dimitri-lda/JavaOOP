package gb;

import java.util.ArrayList;

/**
 * Крестьянин
 */
public class Farmer extends BaseHero {
    private final String type = "Крестьянин";
    private boolean available = true;

    public Farmer(String name, int hp, int x, int y) {
        super("Farmer_" + name, hp, x, y);
    }

    public Farmer(String name, int x, int y) {
        super(name, x, y);
    }

    protected String getType() {
        return this.type;
    }

    public boolean isAliveAndAvailable() {
        return !this.isDead() && this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> teamMates) {
        if (!super.isDead()) {
            this.available = true;
        }
    }
}
