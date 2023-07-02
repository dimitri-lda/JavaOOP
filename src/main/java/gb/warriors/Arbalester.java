package gb.warriors;

import gb.Warrior;

public class Arbalester extends Warrior {
    private String type = "Арбалетчик";

    public Arbalester(String name, int hp) {
        super("Arbalester_" + name, hp);
    }

    public Arbalester(String name) {
        super(name);
    }

    protected int getDamage() {
        return super.rand.nextInt(10, 20);
    }

    protected String getType() {
        return this.type;
    }
}
