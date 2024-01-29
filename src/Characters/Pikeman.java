package Characters;

import Сharacter_Basic.BasicHero;
import Сharacter_Basic.Melee;

public class Pikeman extends Melee {
    public Pikeman(String nameHero, int pos_X, int pos_Y){
        super(  100,
                100,
                5,
                new int[] {17, 28},
                nameHero,
                pos_X, pos_Y,
                1);
        max = current = 3;
        endurance = 75;
        strength = 17;
        step = 1;
    }

    @Override
    public String toString(){
        return "Копейщик: " + super.toString();
    }

    @Override
    public String getInfo(){
        return "Копейщик";
    }
}
