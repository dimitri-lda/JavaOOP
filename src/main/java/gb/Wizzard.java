package gb;

public abstract class Wizzard extends BaseHero {
    public Wizzard(String name, int hp, int x, int y) {
        super(name, hp, x, y);
    }

    public Wizzard(String name, int x, int y) {
        super(name, x, y);
    }

    protected abstract int getHealAmount();

    public void heal(BaseHero hero) {
        System.out.println(super.getName() + " лечит " + hero.getName());
        hero.takeHeal(this.getHealAmount());
    }
}
