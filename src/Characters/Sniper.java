package Characters;

import Сharacter_Basic.Archer;
import Сharacter_Basic.Vector2;


public class Sniper extends Archer {
    public Sniper(String nameHero, int pos_X, int pos_Y){
        super(  75,
                75,
                9,
                new int[] {11, 16},
                nameHero,
                pos_X, pos_Y,
                3);
        maxArrows = currentArrows = 30;
        maxRange = 9;
        updatedArcher = new Rogue(this.nameHero, this.pos_X, this.pos_X);
        updatedArcher.position = this.position;
        updatedArcher.damage = new int[] {6, 7};
    }

    @Override
    public String toString(){
        return "Снайпер: " + super.toString();
    }

    @Override
    public String getInfo(){
        return "Снайпер";
    }

}
