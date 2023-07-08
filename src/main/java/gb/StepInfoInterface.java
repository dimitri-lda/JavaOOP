package gb;

import java.util.ArrayList;

public interface StepInfoInterface {
    void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> teamMates);
    String getInfo();
}
