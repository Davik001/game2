package game.character;

import java.util.Random;

public class Evasion extends Character { // монстр может укланяться с некоторой вероятностью

    private double dodgeChance;
    private Random random = new Random();

    public Evasion(int h, int a, int d, double dodgeChance){
        super(h, a, d);
        this.dodgeChance = dodgeChance;
    }

    @Override
    public String getName(){
        return "Ловкий Монстр";
    }

    @Override
    protected void printDefend() {
        System.out.println("Ловкий монстр защищается!");
    }

    @Override
    protected void printAttack(int damage) {
        System.out.println("Ловкий монстр атакует!! Нанесено " + damage + " урона");
    }

    @Override
    public int hit(int damagePower){
        if(isDodging()){
            System.out.println("Монстр уклонился от удара!!!");
            return 0;
        }
         return super.hit(damagePower);
    }

    public boolean isDodging(){
        return random.nextDouble() < dodgeChance;
    }

}
