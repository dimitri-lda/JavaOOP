package gb.warriors;

import gb.Warrior;

public class Sniper extends Warrior {
    private String type = "Снайпер";

    public Sniper(String name, int hp, int x, int y) {
        super("Sniper_" + name, hp, x, y);
    }

    public Sniper(String name, int x, int y) {
        super(name, x, y);
    }

    protected int getDamage() {
        return super.rand.nextInt(10, 20);
    }

    protected String getType() {
        return this.type;
    }
}
