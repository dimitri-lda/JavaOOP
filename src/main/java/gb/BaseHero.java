package gb;

import java.util.Random;

public abstract class BaseHero implements StepInfoInterface {
    private static final int DEFAULT_HEALTH = 100;
    protected Random rand = new Random();
    private final String name;
    private final int maxHp;
    private int hp;

    public BaseHero(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public BaseHero(String name) {
        this(name, DEFAULT_HEALTH);
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public boolean isDead() {
        return this.hp == 0;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void takeHeal(int heal) {
        this.hp += heal;
        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    public void step() {
    }

    public String getInfo() {
        return this.name + ", тип: " + this.getType() + ", здоровье: " + this.hp + "/" + this.maxHp;
    }

    abstract protected String getType();
}
