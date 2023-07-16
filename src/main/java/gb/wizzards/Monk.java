package gb.wizzards;

import gb.Wizzard;

public class Monk extends Wizzard {
    private String type = "Монах";

    public Monk(String name, int hp, int x, int y) {
        super("Monk_" + name, hp, x, y);
    }

    public Monk(String name, int x, int y) {
        super(name, x, y);
    }

    protected int getHealAmount() {
        return super.rand.nextInt(3, 5);
    }

    protected String getType() {
        return this.type;
    }
}
