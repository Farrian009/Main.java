package Сharacter_Basic;
import java.util.ArrayList;
import java.util.Random;

public abstract class Magician extends BasicHero{
    protected int maxMana, currentMana, generationMana, intelligence, manaCost;
    boolean flagRespaun;
    Random random = new Random();

    public Magician(int healthCurrent, int healthMax, int armor, int[] damage, String nameHero, int pos_X, int pos_Y, int effort) {
        super(healthCurrent, healthMax, armor, damage, nameHero, pos_X, pos_Y, effort);
        this.maxMana = maxMana;
        this.currentMana = currentMana;
        this.generationMana = generationMana;
        this.intelligence = intelligence;
    }



    @Override
    public String toString(){
        return (nameHero + " здоровье: " + healthCurrent + "/" + healthMax + " координаты " + pos_X + "/" + pos_Y);
    }

    public void getHealing(BasicHero injured){
        if (injured.healthCurrent > 0 && injured.healthCurrent < injured.healthMax){
            healingPoints = this.random.nextInt(damage[0], damage[1]);
            injured.healthCurrent = injured.healthCurrent + healingPoints;
            if (injured.healthCurrent > injured.healthMax){
                injured.healthCurrent = injured.healthMax;
            }
        }
    }

    @Override
    public void stepInGame(ArrayList<BasicHero> enemies, ArrayList<BasicHero> allies){
        if (this.healthCurrent == 0) return;
        getRespaun(enemies, allies);
        if (!flagRespaun){
            getHealing(findMinHealthAllies(allies));
        }
        this.currentMana += generationMana;
        if (currentMana > maxMana){
            currentMana = maxMana;
        }
    }

    public void getRespaun(ArrayList<BasicHero> enemies, ArrayList<BasicHero> allies){
        if (!flagRespaun && random.nextInt(0, 5) != 4) {
            return;
        }
        if (allies.stream().allMatch(n -> !n.getType().equals("Archer") || n.healthCurrent < 1)){
            flagRespaun = true;
            if (this.currentMana < maxMana) return;
            for (BasicHero h: allies) {
                if (h.getType().equals("Archer")){
                    for (BasicHero e: enemies) {
                        if (h.position.rangeToEnemy(e.position) == 0){
                            return;
                        }
                    }
                    for (BasicHero a: allies) {
                        if (h.position.rangeToEnemy(a.position) == 0){
                            return;
                        }
                    }
                    h.healthCurrent = h.healthMax;
                    this.currentMana -= maxMana / 2;
                    flagRespaun = false;
                    return;
                }
            }
        }
    }

    @Override
    public String getType(){
        return "Magician";
    }

}

