package gb.warriors;

import gb.Warrior;

public class Bandit extends Warrior {
    public Bandit(String name, int hp) {
        super("Bandit_" + name, hp);
    }

    public Bandit(String name) {
        super("Bandit_" + name);
    }

    protected int getDamage() {
        return super.rand.nextInt(7, 15);
    }
}
