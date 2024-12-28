package game.character;

import java.util.Random;

public class Ravager extends Character { // каждый ход становится слека сильнее

    private int incrementAttack;
    private Random random = new Random();

    public Ravager(int h, int a, int d, int incrementAttack){
        super(h, a, d);
        this.incrementAttack = incrementAttack;
    }

    @Override
    public String getName(){
        return "Усиливающийся Монстр";
    }

    @Override
    protected void printDefend() {
        System.out.println("Усиливающийся монстр защищается!");
    }

    @Override
    protected void printAttack(int damage) {
        System.out.println("Монстр атакует с невообразимой силой!! Нанесено " + damage + " урона");
    }

    @Override
    public void makeAct(Character character){
       strengthInc();
       super.makeAct(character);

    }

    private void strengthInc(){
        attack += incrementAttack;
        System.out.println("Монстр усиливается!! Атака: " + attack);
    }


}
