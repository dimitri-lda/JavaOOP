package gb.warriors.infantry;

import gb.warriors.BaseInfantry;

public class Bandit extends BaseInfantry {
    private final String type = "Разбойник";

    public Bandit(String name, int x, int y) {
        super(name, x, y);
    }

    protected int getDamage() {
        return super.rand.nextInt(7, 15);
    }

    protected String getType() {
        return this.type;
    }
}
