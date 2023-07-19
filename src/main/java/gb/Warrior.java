package gb;

public abstract class Warrior extends BaseHero {
    public Warrior(String name, int hp, int x, int y) {
        super(name, hp, x, y);
    }

    public Warrior(String name, int x, int y) {
        super(name, x, y);
    }

    protected abstract int getDamage();
    public void attackEnemy(BaseHero enemy) {
        enemy.takeDamage(this.getDamage());
    }
}
