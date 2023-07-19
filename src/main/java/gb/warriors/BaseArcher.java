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
    public String getInfo() {
        return super.getInfo() . concat(", ⚔:" + this.arrows);
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> teamMates) {
        if (this.arrows == 0 || super.isDead()) {
            return;
        }

        BaseHero closestEnemy = super.getClosestEnemy(enemies);
        if (closestEnemy == null) {
            return;
        }
        super.attackEnemy(closestEnemy);

        Farmer farmer = this.getFirstAvailableFarmer(teamMates);
        if (farmer != null) {
            farmer.setAvailable(false);
        } else {
            this.removeArrows();
        }
    }

    public boolean hasArrowsOrAliveFarmerInTeam(ArrayList<BaseHero> teamMates) {
        return this.hasAliveFarmerInTeam(teamMates) || this.arrows > 0;
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

    private boolean hasAliveFarmerInTeam(ArrayList<BaseHero> teamMates) {
        for (BaseHero baseHero : teamMates) {
            if (!baseHero.isDead() && baseHero instanceof Farmer) {
                return true;
            }
        }
        return false;
    }
}
