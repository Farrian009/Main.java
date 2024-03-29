package Сharacter_Basic;

import java.util.ArrayList;
import java.util.Random;

public abstract class Archer extends BasicHero{
    protected int maxArrows, currentArrows, maxRange;
    Random random = new Random();
    protected BasicHero updatedArcher;

    public Archer(int healthCurrent, int healthMax, int armor, int[] damage, String nameHero, int pos_X, int pos_Y, int effort) {
        super(healthCurrent, healthMax, armor, damage, nameHero, pos_X, pos_Y, effort);
        this.maxArrows = maxArrows;
        this.currentArrows = currentArrows;
        this.maxRange = maxRange;
    }

    @Override
    public String toString(){
        return (nameHero + " здоровье: " + healthCurrent + "/" + healthMax + " координаты " + pos_X + "/" + pos_Y);
    }

    public int getCurrentArrows(){
        return currentArrows;
    }

    public void setCurrentArrows(int arrows){
        this.currentArrows = currentArrows + arrows;
        if (currentArrows > maxArrows){
            currentArrows = maxArrows;
        }
    }

    public int getMaxArrows(){
        return maxArrows;
    }

//    public BasicHero findArcherToRefill(ArrayList<BasicHero> allies){
//        BasicHero archerToRefill;
//                for (int i = 0; i < allies.size(); i++){
//            if (allies.get(i).healthCurrent > 0 && allies.contains(currentArrows)) {
//                ArrayList<Archer> archersListTMP = new ArrayList<>();
//                archersListTMP.add((Archer) allies.get(i));
//                archerToRefill = archersListTMP.get(0);
//                int arrowsTMP = archersListTMP.get(0).currentArrows;
//                if (archersListTMP.get(i).currentArrows < arrowsTMP || archersListTMP.get(i).currentArrows < archersListTMP.get(i).maxArrows) {
//                    archerToRefill = archersListTMP.get(i);
//                    arrowsTMP = archersListTMP.get(i).currentArrows;
//                }
//            }
//        }
//        return archerToRefill;
//    }

//    public BasicHero findEnemy(ArrayList<BasicHero> enemies){
//        BasicHero heroToShoot = enemies.get(0);
//        for (int i = 0; i < enemies.size(); i++){
//            if (heroToShoot.healthCurrent < heroToShoot.healthMax){
//                heroToShoot = enemies.get(i);
//            }
//        }
//        if (this.position.rangeToEnemy(heroToShoot.position) > maxRange){
//            for (BasicHero h: enemies){
//                if (heroToShoot.healthCurrent > h.healthCurrent){
//                    heroToShoot = h;
//                }
//            }
//        }
//        return heroToShoot;
//    }

    @Override
    public void stepInGame(ArrayList<BasicHero> enemies, ArrayList<BasicHero> allies){
        if (healthCurrent == 0) return;
        if (currentArrows == 0){
            updatedArcher.healthCurrent = healthCurrent;
            updatedArcher.stepInGame(enemies, allies);
            position = updatedArcher.position;
            return;
        }
        BasicHero heroTMP = findNextEnemy(enemies);
        int damageTMP;
        if (this.position.rangeToEnemy(heroTMP.position) <= maxRange){
            damageTMP = this.random.nextInt(damage[0], damage[1]);
            attack(heroTMP, damageTMP);
//            System.out.println("Нанесен урон" + this.nameHero + "/" + heroTMP.nameHero + damageTMP);
        } else {
            damageTMP = this.random.nextInt(5, damage[0]);
            attack(heroTMP, damageTMP);
//            System.out.println("Нанесен урон" + this.nameHero + "/" + heroTMP.nameHero + damageTMP);
        }
        currentArrows --;
    }

    @Override
    public String getType(){
        return "Archer";
    }

    public Vector2 moveArcher(BasicHero enemy){
        Vector2 delta = position.getDirection(enemy.position);
        Vector2 directionTMP = new Vector2(position.pos_X, position.pos_Y);
        if (delta.pos_X < 0){
            directionTMP.pos_X++;
            return directionTMP;
        }
        if (delta.pos_X > 0){
            directionTMP.pos_X++;
            return directionTMP;
        }
        if (delta.pos_Y < 0){
            directionTMP.pos_Y++;
            return directionTMP;
        }
        if (delta.pos_Y < 0){
            directionTMP.pos_Y++;
            return directionTMP;
        }
        return directionTMP;
    }
}
