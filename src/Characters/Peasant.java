package Characters;

import Сharacter_Basic.Archer;
import Сharacter_Basic.BasicHero;

import java.util.ArrayList;

public class Peasant extends BasicHero {
    public Peasant(String nameHero, int pos_X, int pos_Y){
        super(70,
                70,
                0,
                new int[] {0, 0},
                nameHero,
                pos_X, pos_Y,
                0);
    }

    @Override
    public String toString(){
        return ("Крестьянин: " + nameHero + " здоровье: " + healthCurrent + "/" + healthMax + " координаты " + pos_X + "/" + pos_Y);
    }

    @Override
    public void stepInGame(ArrayList<BasicHero> enemies, ArrayList<BasicHero> allies) {
        if (this.healthCurrent == 0) return;
        for (int i = 0; i < allies.size(); i++){
            ArrayList<Archer> archersListTMP = new ArrayList<>();
            if (allies.get(i).healthCurrent > 0 && allies.contains()){

                archersListTMP.add((Archer) allies.get(i));
            }
        }
    }

    public void giveArrow(Archer archer){
        if (archer == null) {
            return;
        }
        if (archer.getCurrentArrows() < archer.getMaxArrows()){
            archer.setCurrentArrows(1);
        }
    }

    @Override
    public String getInfo(){
        return "Крестьянин";
    }

    @Override
    public String getType(){
        return "Peasant";
    }

}

