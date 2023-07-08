package gb.wizzards;

import gb.Wizzard;

public class Magican extends Wizzard {
    private String type = "Монах";

    public Magican(String name, int hp, int x, int y) {
        super("Magican_" + name, hp, x, y);
    }

    public Magican(String name, int x, int y) {
        super(name, x, y);
    }

    protected int getHealAmount() {
        return super.rand.nextInt(10, 20);
    }

    protected String getType() {
        return this.type;
    }
}
