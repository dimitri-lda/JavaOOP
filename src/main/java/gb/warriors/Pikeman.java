package gb.warriors;

import gb.Warrior;

/**
 * Копейщик
 */
public class Pikeman extends Warrior {
    private String type = "Копейщик";

    public Pikeman(String name, int hp, int x, int y) {
        super("Pikeman_" + name, hp, x, y);
    }

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
