package gb.wizzards;

import gb.Wizzard;

public class Monk extends Wizzard {
    public Monk(String name, int hp) {
        super("Monk_" + name, hp);
    }

    public Monk(String name) {
        super("Monk_" + name);
    }

    protected int getHealAmount() {
        return super.rand.nextInt(15, 25);
    }
}
