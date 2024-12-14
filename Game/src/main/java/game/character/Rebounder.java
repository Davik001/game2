package game.character;

import java.util.Random;

public class Rebounder extends Character { // может отражать урон обратно в игрока

    private Random random = new Random();
    private int reflectionChance;

    public Rebounder(int h, int a, int d, int reflectionChance){
        super(h, a, d);
        this.reflectionChance = reflectionChance;
    }

    @Override
    public String getName() {
        return "Отражающий Монстр";
    }

    @Override
    protected void printDefend() {
        System.out.println("Монстр защищается!");
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
                reflection(character);
                break;
            default:
                System.out.println("Неизвестное действие");
                break;
        }
    }

    private void reflection(Character character) {
        if (random.nextInt(5) < reflectionChance && character.action == Action.ATTACK) {
            System.out.println("Монстр отражает урон обратно в игрока!");
            character.hit(character.attack);
        }
    }
}
