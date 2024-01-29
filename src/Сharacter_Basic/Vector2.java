package Сharacter_Basic;

public class Vector2 {

    int pos_X, pos_Y;

    public Vector2 (int pos_X, int pos_Y) {
        this.pos_X = pos_X;
        this.pos_Y = pos_Y;

    }

    public float rangeToEnemy(Vector2 posEnemy){
        double distance = Math.sqrt(Math.pow(posEnemy.pos_X-pos_X, 2) + Math.pow(posEnemy.pos_Y-pos_Y, 2));
        return (float) distance;
    }

    public Vector2 getDirection(Vector2 posEnemy){
        return new Vector2(pos_X-posEnemy.pos_X, pos_Y-posEnemy.pos_Y);
    }

    public boolean equals(Vector2 posEnemy){
        return pos_X == posEnemy.pos_X & pos_Y == posEnemy.pos_Y;
    }


}
