package Characters;

import Сharacter_Basic.Archer;

public class Crossbowyer extends Archer {
    public Crossbowyer(String nameHero, int pos_X, int pos_Y){
        super(  80,
                80,
                5,
                new int[] {9, 13},
                nameHero,
                pos_X, pos_Y,
                3);
        maxArrows = currentArrows = 30;
        maxRange = 13;
        updatedArcher = new Pikeman(this.nameHero, this.pos_X, this.pos_X);
        updatedArcher.position = this.position;
        updatedArcher.damage = new int[] {5, 6};
    }

    @Override
    public String toString(){
        return "Арбалетчик: " + super.toString();
    }

    @Override
    public String getInfo(){
        return "Арбалетчик";
    }

}
