package gb.warriors.archers;

import gb.warriors.BaseArcher;

public class Arbalester extends BaseArcher {
    private String type = "Арбалетчик";

    public Arbalester(String name, int hp, int x, int y) {
        super("Arbalester_" + name, hp, x, y);
    }

    public Arbalester(String name, int x, int y) {
        super(name, x, y);
    }

    protected int getDamage() {
        return super.rand.nextInt(10, 20);
    }

    protected String getType() {
        return this.type;
    }
}
