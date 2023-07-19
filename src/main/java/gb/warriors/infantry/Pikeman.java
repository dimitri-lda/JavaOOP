package gb.warriors.infantry;

import gb.warriors.BaseInfantry;

/**
 * Копейщик
 */
public class Pikeman extends BaseInfantry {
    private final String type = "Копейщик";

    public Pikeman(String name, int x, int y) {
        super(name, x, y);
    }

    protected int getDamage() {
        return super.rand.nextInt(12, 25);
    }

    protected String getType() {
        return this.type;
    }
}
