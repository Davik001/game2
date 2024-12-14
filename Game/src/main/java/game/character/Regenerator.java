package game.character;

import java.util.Random;

public class Regenerator extends Character { // восстанавливает здоровье после каждого хода

    private Random random = new Random();
    private int healthIncrement;

    public Regenerator(int h, int a, int d, int healtIncrement){
        super(h, a, d);
        this.healthIncrement = healtIncrement;
    }

    @Override
    public String getName() {
        return "Регенерирующий Монстр";
    }

    @Override
    protected void printDefend() {
        System.out.println("Монстр регенерирует!!");
    }

    @Override
    protected void printAttack(int damage) {
        System.out.println("Монстр атакует!! Нанесено " + damage + " урона");
    }


    @Override
    public void makeAct(Character character) {

        int damage = 0;
        switch (action){
            case ATTACK:
                charAttack(character);
                break;
            case DEFEND:
                printDefend();
                health += healthIncrement;
                break;
            default:
                System.out.println("Неизвестное действие");
                break;
        }
    }

}
