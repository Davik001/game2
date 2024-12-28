package game.character;

import java.util.Random;

public class Furious extends Character { // может нанести повышенный урон с какой то вероятностью

    private int criticalChance; // для опеределения вероятности
    private int criticalHit; // для повышения урона
    private Random random = new Random();

    public Furious(int h, int a, int d, int criticalChance, int criticalHit){
        super(h, a, d);
        this.criticalChance = criticalChance;
        this.criticalHit = criticalHit;
    }

    @Override
    public String getName(){
        return "Яростный Монстр";
    }

    @Override
    protected void printDefend() {
        System.out.printf("Яростный монстр защищается!");
    }

    @Override
    protected void printAttack(int damage) {
        System.out.printf("Яростный монстр атакует! Нанесено " + damage + " урона");
    }

    @Override
    public void makeAct(Character character) {

        switch (action){
            case ATTACK:
                criticHit();
                charAttack(character);
            break;
            case DEFEND:
                printDefend();
                break;
            default:
                System.out.println("Неизвестное действие");
                break;
        }
    }

    private int criticHit(){
        int damage = 0;
       boolean isCritical = random.nextInt() < criticalChance;
        if(isCritical){
            damage = getAttack() + criticalHit;
            System.out.printf("Критический удар! Урон увеличен до " + damage);
        }

        if(damage <= 0){
            damage = 0;
        }
        return damage;
    }
}
