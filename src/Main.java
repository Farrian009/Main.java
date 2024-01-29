import Characters.*;
import Сharacter_Basic.BasicHero;

import java.util.*;

public class Main {
    public static ArrayList<BasicHero> heroesWhite = new ArrayList<>();
    public static ArrayList<BasicHero> heroesBlack = new ArrayList<>();
    public static ArrayList<BasicHero> heroesEffortSorted = new ArrayList<>();

    public static void main(String[] args) {
        heroesBlack = createTeam(0, 1);
        heroesWhite = createTeam(3, 10);

        heroesEffortSorted.addAll(heroesWhite);
        heroesEffortSorted.addAll(heroesBlack);
        heroesEffortSorted.sort(new Comparator<BasicHero>() {
            @Override
            public int compare(BasicHero o1, BasicHero o2) {
                return o2.getEffort() - o1.getEffort();
            }
        });

        System.out.println();
        Scanner input = new Scanner(System.in);
        boolean flag;
        while (true){
            View.view();
            if (gameOverWhite()){
                flag = true;
                break;
            }
            if (gameOverBlack()){
                flag = false;
                break;
            }
            input.nextLine();
            for (BasicHero h : heroesEffortSorted){
                if(heroesBlack.contains(h)){
                    h.stepInGame(heroesWhite, heroesBlack);
                } else {
                    h.stepInGame(heroesBlack, heroesWhite);
                }
            }
        }
        if (flag) {
            System.out.println("White win!");
        } else {
            System.out.println("Black win!");
        }

//        heroesWhite.forEach(n -> System.out.println(n.toString()));
//        System.out.println();
//        heroesWhite.forEach(n -> n.printEnemyDistance(heroesBlack));
//        System.out.println("*******************************");
//        System.out.println("Black team");
//        heroesBlack.forEach(n -> System.out.println(n.toString()));
//        System.out.println();
//        heroesBlack.forEach(n -> n.printEnemyDistance(heroesWhite));
    }

    static ArrayList<BasicHero> createTeam(int n, int y){
        ArrayList<BasicHero> teamMembers = new ArrayList<>();
        Random random = new Random();
        int rand;
        for (int i = 1; i < 11; i++){
            rand = random.nextInt(1, 5) + n;
            switch (rand){
                case 1:
                    teamMembers.add(new Crossbowyer(getName(), i, y));
                    break;
                case 2:
                    teamMembers.add(new Monk(getName(), i, y));
                    break;
                case 3:
                    teamMembers.add(new Pikeman(getName(), i, y));
                    break;
                case 4:
                    teamMembers.add(new Peasant(getName(), i, y));
                    break;
                case 5:
                    teamMembers.add(new Rogue(getName(), i, y));
                    break;
                case 6:
                    teamMembers.add(new Sniper(getName(), i, y));
                    break;
                case 7:
                    teamMembers.add(new Wizard(getName(), i, y));
                    break;
            }
        }
        return teamMembers;
    }

    static String getName(){
        return NameOfHeroes.values()[new Random().nextInt(NameOfHeroes.values().length-1)].name();
    }

    public static boolean gameOverWhite(){
        for (BasicHero h : heroesWhite) {
            if (h.healthCurrent > 0) return false;
        }
        return true;
    }

    public static boolean gameOverBlack(){
        for (BasicHero h : heroesBlack) {
            if (h.healthCurrent > 0) return false;
        }
        return true;
    }

}
