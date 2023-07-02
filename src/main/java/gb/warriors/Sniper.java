package gb.warriors;

import gb.Warrior;

public class Sniper extends Warrior {
    private String type = "Снайпер";

    public Sniper(String name, int hp) {
        super("Sniper_" + name, hp);
    }

    public Sniper(String name) {
        super(name);
    }

    protected int getDamage() {
        return super.rand.nextInt(10, 20);
    }

    protected String getType() {
        return this.type;
    }
}
