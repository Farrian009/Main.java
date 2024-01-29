package Сharacter_Basic;

import java.util.ArrayList;
import java.util.Random;

public abstract class Melee extends BasicHero{
    protected int max, current, endurance, strength, step, damagePoint;
    Random random = new Random();

    public Melee(int healthCurrent, int healthMax, int armor, int[] damage, String nameHero, int pos_X, int pos_Y, int effort) {
        super(healthCurrent, healthMax, armor, damage, nameHero, pos_X, pos_Y, effort);
        this.max = max;
        this.current = current;
        this.endurance = endurance;
        this.strength = strength;
        this.step = step;
    }

    public Vector2 moveMelee(BasicHero enemy){
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

    @Override
    public String toString(){
        return (nameHero + " здоровье: " + healthCurrent + "/" + healthMax + " координаты " + pos_X + "/" + pos_Y);
    }
    public void attack(BasicHero enemy, int damage){
        enemy.healthCurrent = enemy.healthCurrent - damage;
        if (healthCurrent < 0){
            healthCurrent = 0;
        }
    }
    @Override
    public void stepInGame(ArrayList<BasicHero> enemies, ArrayList<BasicHero> allies){
        if (this.healthCurrent == 0) return;
        BasicHero heroTMP = findNextEnemy(enemies);
        if (this.position.rangeToEnemy(heroTMP.position) < 2){
            damagePoint = this.random.nextInt(damage[0], damage[1]);
            attack(heroTMP, damagePoint);
        } else {
            Vector2 temprorary = moveMelee(heroTMP);
            boolean step = true;
            for (BasicHero hero : allies){
                if (temprorary.equals((hero.position))) step = false;
            }
            if (step) position = temprorary;
        }
    }

    @Override
    public String getType(){
        return "Melee";
    }
}
