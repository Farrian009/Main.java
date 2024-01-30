package Characters;

import Сharacter_Basic.Magician;
import Сharacter_Basic.BasicHero;

public class Wizard extends Magician {
    public Wizard(String nameHero, int pos_X, int pos_Y){
        super(  75,
                75,
                0,
                new int[] {7, 14},
                nameHero,
                pos_X, pos_Y,
                2);
        maxMana = currentMana = 95;
        generationMana = 14;
        intelligence = 13;
    }

    @Override
    public String toString(){
        return "Волшебник: " + super.toString();
    }

    @Override
    public String getInfo(){
        return "Волшебник";
    }

    @Override
    public String getType() {
        return "Wizard";
    }
}
