package game.character;


import game.strategy.AbstractChooseStrategy;

public abstract class Character {
    protected int health;
    protected int attack;
    protected int defense; // защита для уменьшения урона
    protected Action action;
    protected AbstractChooseStrategy chooseStrategy;

    public Character(){}


    public Character(int health, int attack, int defense){
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }


    // геттеры и сеттеры
    public int getHealth(){
        return health;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
         return defense;
    }

    public void setHealth(int health){
        this.health = health;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }

    public abstract String getName();
    public Action getAction(){
        return action;
    }

    public void setStrategy(AbstractChooseStrategy chooseStrategy){
        this.chooseStrategy = chooseStrategy;
        chooseStrategy.setCharacter(this);
    }

    public void setAction(Action action){
        this.action = action;
    }



    public int hit(int damagePower){
        int damage = 1;

        if(action == Action.DEFEND){ // если защита используется
            damage = damagePower - (defense * 2);
        } else { // если защита не используется, то полный урон
                damage = damagePower - getDefense();
        }

        if(damage <= 0){
            damage = 0;
        }
        health -= damage;
        return damage;
    }

    // информация о дейтсвиях
    protected abstract void printDefend();
    protected abstract void printAttack(int damage);
    public boolean isAlive(){
        return health > 0;
    }

    public void chooseAction(){
        chooseStrategy.selectAction();
    }

    public void makeAct(Character character){

        int damage = 0;

        switch(action){
            case ATTACK:
                charAttack(character);
                break;
            case DEFEND:
                printDefend();
                break;
            default:
                System.out.println("Неизвестное действие..");
                break;
        }
    }

    protected void charAttack(Character character) {
        int damage = character.hit(getAttack());
        printAttack(damage);
    }


}
