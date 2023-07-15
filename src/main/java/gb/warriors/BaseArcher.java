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
        if (this.arrows == 0 || super.isDead()) {
            System.out.println(super.getName() + " не может сделать шаг, у него закончились стрелы или он погиб");
            return;
        }

        BaseHero closestEnemy = super.getClosestEnemy(enemies);
        this.attackEnemy(closestEnemy);

        Farmer farmer = this.getFirstAvailableFarmer(teamMates);
        if (farmer != null) {
            farmer.setAvailable(false);
        } else {
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

    private Farmer getFirstAvailableFarmer(ArrayList<BaseHero> teamMates) {
        for (BaseHero baseHero : teamMates) {
            if (baseHero instanceof Farmer && ((Farmer) baseHero).isAliveAndAvailable()) {
                return (Farmer) baseHero;
            }
        }
        return null;
    }
}
