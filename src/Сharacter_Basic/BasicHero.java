package Сharacter_Basic;

import Actions.GameInterface;

import java.util.ArrayList;
import java.util.Collections;

public abstract class BasicHero implements GameInterface {
    public int healthCurrent, healthMax, armor, pos_X, pos_Y;
    protected int[] damage;

    protected String nameHero;
    public Vector2 position;
    protected int effort;

    public BasicHero(int healthCurrent, int healthMax, int armor, int[] damage, String nameHero, int pos_X, int pos_Y, int effort){
        this.healthCurrent = healthCurrent;
        this.healthMax = healthMax;
        this.armor = armor;
        this.damage = damage;
        this.nameHero = nameHero;
        this.position = new Vector2(pos_X, pos_Y);
        this.effort = effort;
    }

    public void printEnemyDistance(ArrayList<BasicHero> enemies){
        enemies.forEach(n-> System.out.print(position.rangeToEnemy(n.position) + ", "));
        System.out.println();
    }

    public BasicHero findNextEnemy(ArrayList<BasicHero> enemies){
        BasicHero closestEnemy = null;
        for (int i = 1; i < enemies.size(); i++){
            if (enemies.get(i).healthCurrent > 0) {
                if (closestEnemy == null || enemies.get(i).healthCurrent > 0 && this.position.rangeToEnemy(enemies.get(i).position) < this.position.rangeToEnemy(closestEnemy.position)){
                    closestEnemy = enemies.get(i);
                }
            }
        }
        return closestEnemy;
    }

    public abstract void stepInGame(ArrayList<BasicHero> enemies, ArrayList<BasicHero> allies);

    public int getEffort(){
        return effort;
    }

    protected void attack(BasicHero enemy, int damage){
        enemy.healthCurrent -= damage;
        if (enemy.healthCurrent < 0){
            enemy.healthCurrent = 0;
        }
    }

    public int[] getCoords(){
        return new int[] {position.pos_X, position.pos_Y};
    }

    public int getHp(){
        return healthCurrent;
    }

    abstract public String getInfo();

    abstract public String getType();


}
