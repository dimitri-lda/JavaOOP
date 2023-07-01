package gb;

import java.util.Random;

public abstract class BaseHero {
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
}
