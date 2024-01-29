package Characters;

import Сharacter_Basic.Magician;

public class Monk extends Magician {
    public Monk(String nameHero, int pos_X, int pos_Y){
        super(  65,
                65,
                3,
                new int[] {10, 15},
                nameHero,
                pos_X, pos_Y,
                2);
        maxMana = currentMana = 105;
        generationMana = 8;
        intelligence = 16;
    }

    @Override
    public String toString(){
        return "Монах: " + super.toString();
    }

    @Override
    public String getInfo(){
        return "Монах";
    }

}
