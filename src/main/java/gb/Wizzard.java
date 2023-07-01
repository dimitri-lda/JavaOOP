package gb;

public abstract class Wizzard extends BaseHero {
    public Wizzard(String name, int hp) {
        super(name, hp);
    }

    public Wizzard(String name) {
        super(name);
    }

    protected abstract int getHealAmount();

    public void heal(BaseHero hero) {
        System.out.println(super.getName() + " лечит " + hero.getName());
        hero.takeHeal(this.getHealAmount());
    }
}
