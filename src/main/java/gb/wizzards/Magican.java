package gb.wizzards;

import gb.Wizzard;

public class Magican extends Wizzard {
    public Magican(String name, int hp) {
        super("Magican_" + name, hp);
    }

    public Magican(String name) {
        super("Magican_" + name);
    }

    protected int getHealAmount() {
        return super.rand.nextInt(10, 20);
    }
}
