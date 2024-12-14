package game.character;


public class Monster extends Character {

    public Monster(int h, int a, int d){
        super(h, a, d); // используем конструктор родительского класса
    }

    @Override
    protected void printDefend() {
        System.out.println("Монстр защищается!");
    }

    @Override
    protected void printAttack(int damage) {
        System.out.println("Монстр атакует!! Нанесено " + damage + " урона ");
    }

    @Override
    public String getName(){
        return "обычный Монстр";
    }

}
