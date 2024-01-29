package Actions;

import Сharacter_Basic.BasicHero;

import java.util.ArrayList;

public interface GameInterface {
    void stepInGame(ArrayList<BasicHero> enemies, ArrayList<BasicHero> allies);

}
