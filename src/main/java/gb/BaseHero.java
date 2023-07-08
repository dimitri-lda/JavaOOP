package gb;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements StepInfoInterface {
    private static final int DEFAULT_HEALTH = 100;
    protected Random rand = new Random();
    private final String name;
    private final int maxHp;
    private int hp;
    private final Coordinates coordinates;

    public BaseHero(String name, int hp, int x, int y) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.coordinates = new Coordinates(x, y);
    }

    public BaseHero(String name, int x, int y) {
        this(name, DEFAULT_HEALTH, x, y);
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public boolean isDead() {
        return this.hp == 0;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void takeHeal(int heal) {
        this.hp += heal;
        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> teamMates) {
    }

    public String getInfo() {
        return this.name
                + ", тип: " + this.getType()
                + ", здоровье: " + this.hp + "/" + this.maxHp
                + ", координаты: " + this.coordinates.getX() + ", " + this.coordinates.getY();
    }

    abstract protected String getType();

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public BaseHero getClosestEnemy(ArrayList<BaseHero> enemies) {
        BaseHero closestEnemy = null;
        double closestDistance = 0;
        for (BaseHero enemy : enemies) {
            double distance = Math.sqrt(Math.pow(this.getCoordinates().getX() - enemy.getCoordinates().getX(), 2)
                    + Math.pow(this.getCoordinates().getY() - enemy.getCoordinates().getY(), 2));
            if (closestEnemy == null || distance < closestDistance) {
                closestEnemy = enemy;
                closestDistance = distance;
            }
        }
        return closestEnemy;
    }

    public double getDistanceToEnemy(BaseHero enemy) {
        return Math.sqrt(Math.pow(this.getCoordinates().getX() - enemy.getCoordinates().getX(), 2)
                + Math.pow(this.getCoordinates().getY() - enemy.getCoordinates().getY(), 2));
    }
}
