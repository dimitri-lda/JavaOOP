package gb.warriors;

import gb.Warrior;

public class Arbalester extends Warrior {
    public Arbalester(String name, int hp) {
        super("Arbalester_" + name, hp);
    }

    public Arbalester(String name) {
        super("Arbalester_" + name);
    }

    protected int getDamage() {
        return super.rand.nextInt(10, 20);
    }
}
