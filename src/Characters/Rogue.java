package Characters;

import Сharacter_Basic.BasicHero;
import Сharacter_Basic.Melee;

public class Rogue extends Melee {
    public Rogue(String nameHero, int pos_X, int pos_Y){
        super(  93,
                93,
                7,
                new int[] {20, 30},
                nameHero,
                pos_X, pos_Y,
                1);
        max = current = 3;
        endurance = 70;
        strength = 24;
        step = 1;
    }

    @Override
    public String toString(){
        return "Разбойник: " + super.toString();
    }

    @Override
    public String getInfo(){
        return "Разбойник";
    }

    @Override
    public String getType() {
        return "Rogue";
    }
}
