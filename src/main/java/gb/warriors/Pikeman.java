package gb.warriors;

import gb.Warrior;

/**
 * Копейщик
 */
public class Pikeman extends Warrior {
    private String type = "Копейщик";

    public Pikeman(String name, int hp) {
        super("Pikeman_" + name, hp);
    }

    public Pikeman(String name) {
        super(name);
    }

    protected int getDamage() {
        return super.rand.nextInt(12, 25);
    }

    protected String getType() {
        return this.type;
    }
}
