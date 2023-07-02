package gb.wizzards;

import gb.Wizzard;

public class Magican extends Wizzard {
    private String type = "Монах";

    public Magican(String name, int hp) {
        super("Magican_" + name, hp);
    }

    public Magican(String name) {
        super(name);
    }

    protected int getHealAmount() {
        return super.rand.nextInt(10, 20);
    }

    protected String getType() {
        return this.type;
    }
}
