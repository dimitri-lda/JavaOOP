package gb.warriors;

import gb.Warrior;

public class Bandit extends Warrior {
    private String type = "Разбойник";

    public Bandit(String name, int hp, int x, int y) {
        super("Bandit_" + name, hp, x, y);
    }

    public Bandit(String name, int x, int y) {
        super(name, x, y);
    }

    protected int getDamage() {
        return super.rand.nextInt(7, 15);
    }

    protected String getType() {
        return this.type;
    }
}
