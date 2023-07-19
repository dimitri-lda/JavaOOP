package gb.warriors.archers;

import gb.warriors.BaseArcher;

public class Sniper extends BaseArcher {
    private final String type = "Снайпер";

    public Sniper(String name, int x, int y) {
        super(name, x, y);
    }

    protected int getDamage() {
        return super.rand.nextInt(10, 20);
    }

    protected String getType() {
        return this.type;
    }
}
