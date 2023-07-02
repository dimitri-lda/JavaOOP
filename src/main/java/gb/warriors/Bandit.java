package gb.warriors;

import gb.Warrior;

public class Bandit extends Warrior {
    private String type = "Разбойник";

    public Bandit(String name, int hp) {
        super("Bandit_" + name, hp);
    }

    public Bandit(String name) {
        super(name);
    }

    protected int getDamage() {
        return super.rand.nextInt(7, 15);
    }

    protected String getType() {
        return this.type;
    }
}
