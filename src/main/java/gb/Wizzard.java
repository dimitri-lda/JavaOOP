package gb;

import java.util.ArrayList;

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

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> teamMates) {
        if (super.isDead()) {
            return;
        }
        BaseHero weakestTeammate = null;
        for (BaseHero hero : teamMates) {
            if (hero.isDead()) {
                continue;
            }
            if (weakestTeammate == null || hero.getHp() < weakestTeammate.getHp()) {
                weakestTeammate = hero;
            }
        }
        if (weakestTeammate != null) {
            this.heal(weakestTeammate);
        }
    }
}
