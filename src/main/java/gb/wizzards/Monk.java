package gb.wizzards;

import gb.Wizzard;

public class Monk extends Wizzard {
    private String type = "Монах";

    public Monk(String name, int hp) {
        super("Monk_" + name, hp);
    }

    public Monk(String name) {
        super(name);
    }

    protected int getHealAmount() {
        return super.rand.nextInt(15, 25);
    }

    protected String getType() {
        return this.type;
    }
}
