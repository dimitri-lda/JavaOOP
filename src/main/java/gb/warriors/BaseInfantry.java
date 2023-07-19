package gb.warriors;

import gb.BaseHero;
import gb.Coordinates;
import gb.Warrior;

import java.util.ArrayList;

public abstract class BaseInfantry extends Warrior {

    public BaseInfantry(String name, int hp, int x, int y) {
        super(name, hp, x, y);
    }

    public BaseInfantry(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> teamMates) {
        if (super.isDead()) {
            return;
        }

        BaseHero closestEnemy = super.getClosestEnemy(enemies);
        if (closestEnemy == null) {
            return;
        }

        if (super.getDistanceToEnemy(closestEnemy) < 2) {
            super.attackEnemy(closestEnemy);
            return;
        }

        Coordinates newPosition = this.getNewPosition(closestEnemy);
        if (!this.isTeammateOnThisPosition(newPosition, teamMates)) {
            this.getCoordinates().setXY(newPosition.getX(), newPosition.getY());
        }
    }

    private Coordinates getNewPosition(BaseHero closestEnemy) {
        Coordinates newPosition = new Coordinates(this.getCoordinates().getX(), this.getCoordinates().getY());
        int differenceX = Math.abs(this.getCoordinates().getX() - closestEnemy.getCoordinates().getX());
        int differenceY = Math.abs(this.getCoordinates().getY() - closestEnemy.getCoordinates().getY());
        if (differenceX > differenceY) {
            if (this.getCoordinates().getX() - closestEnemy.getCoordinates().getX() > 0) {
                newPosition.setX(this.getCoordinates().getX() - 1);
            } else {
                newPosition.setX(this.getCoordinates().getX() + 1);
            }
        } else {
            if (this.getCoordinates().getY() - closestEnemy.getCoordinates().getY() > 0) {
                newPosition.setY(this.getCoordinates().getY() - 1);
            } else {
                newPosition.setY(this.getCoordinates().getY() + 1);
            }
        }
        return newPosition;
    }

    private boolean isTeammateOnThisPosition(Coordinates coordinates, ArrayList<BaseHero> teamMates) {
        for (BaseHero baseHero : teamMates) {
            if (baseHero.getCoordinates().equals(coordinates)) {
                return true;
            }
        }
        return false;
    }
}
