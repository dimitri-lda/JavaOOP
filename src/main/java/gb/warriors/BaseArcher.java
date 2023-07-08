package gb.warriors;

import gb.BaseHero;
import gb.Farmer;
import gb.Warrior;

import java.util.ArrayList;

public abstract class BaseArcher extends Warrior {
    private int arrows;

    public BaseArcher(String name, int hp, int x, int y) {
        super(name, hp, x, y);
        this.arrows = super.rand.nextInt(5, 10);
    }

    public BaseArcher(String name, int x, int y) {
        super(name, x, y);
        this.arrows = super.rand.nextInt(5, 10);
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> teamMates) {
        if (this.arrows == 0) {
            System.out.println(super.getName() + " не может сделать шаг, так как у него закончились стрелы");
            return;
        }
        if (super.isDead()) {
            System.out.println(super.getName() + " не может сделать шаг, так как он погиб");
            return;
        }

        BaseHero closestEnemy = super.getClosestEnemy(enemies);
        this.attackEnemy(closestEnemy);

        if (!this.hasTeamAliveFarmers(teamMates)) {
            this.removeArrows();
        }
        System.out.println("У " + this.getName() + " осталось стрел: " + this.arrows + "\n");
    }

    private void removeArrows() {
        this.arrows--;
        if (this.arrows < 0) {
            this.arrows = 0;
        }
    }

    private boolean hasTeamAliveFarmers(ArrayList<BaseHero> teamMates) {
        for (BaseHero baseHero : teamMates) {
            if (baseHero instanceof Farmer && !baseHero.isDead()) {
                return true;
            }
        }
        return false;
    }
}
