package gb.warriors;

import gb.Warrior;

public class Sniper extends Warrior {
    public Sniper(String name, int hp) {
        super("Sniper_" + name, hp);
    }

    public Sniper(String name) {
        super("Sniper_" + name);
    }

    protected int getDamage() {
        return super.rand.nextInt(10, 20);
    }
}
