package gb.warriors;

import gb.Warrior;

/**
 * Копейщик
 */
public class Pikeman extends Warrior {
    public Pikeman(String name, int hp) {
        super("Pikeman_" + name, hp);
    }

    public Pikeman(String name) {
        super("Pikeman_" + name);
    }

    protected int getDamage() {
        return super.rand.nextInt(12, 25);
    }
}
