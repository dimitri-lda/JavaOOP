package gb;

abstract class BaseHero {
    private static final int DEFAULT_HEALTH = 100;
    private String name;
    private int hp;
    private int maxHp;

    public BaseHero(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public BaseHero(String name) {
        this(name, DEFAULT_HEALTH);
    }

    public String getName() {
        return this.name;
    }
}
