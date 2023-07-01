package gb;

public abstract class Warrior extends BaseHero {
    public Warrior(String name, int hp) {
        super(name, hp);
    }

    public Warrior(String name) {
        super(name);
    }

    protected abstract int getDamage();
    public void attackEnemy(BaseHero enemy) {
        System.out.println(super.getName() + " атакует " + enemy.getName());
        enemy.takeDamage(this.getDamage());
    }
}
