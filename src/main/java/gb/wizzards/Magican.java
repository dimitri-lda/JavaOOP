package gb.wizzards;

import gb.Wizzard;

public class Magican extends Wizzard {
    private final String type = "Монах";

    public Magican(String name, int x, int y) {
        super(name, x, y);
    }

    protected int getHealAmount() {
        return super.rand.nextInt(5, 7);
    }

    protected String getType() {
        return this.type;
    }
}
