package gb;

import java.util.ArrayList;

public abstract class Wizzard extends BaseHero {
    public Wizzard(String name, int hp, int x, int y) {
        super(name, hp, x, y);
    }

    public Wizzard(String name, int x, int y) {
        super(name, x, y);
    }

    protected int healLimit = 100;

    protected abstract int getHealAmount();

    public void heal(BaseHero hero) {
        if (this.healLimit == 0) {
            return;
        }

        int healAmount = this.getHealAmount();
        hero.takeHeal(healAmount);
        System.out.println(super.getName() + " лечит " + hero.getName());

        this.healLimit -= healAmount;
        if (this.healLimit < 0) {
            this.healLimit = 0;
        }
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

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
