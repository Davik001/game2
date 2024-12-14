package game.strategy;

import game.character.Action;
import game.character.Character;

import java.util.Random;

public class MonsterAttackStrategy extends AbstractChooseStrategy {

    private Random random = new Random();

    public MonsterAttackStrategy(Character character){
        this.character = character;
    }

    public MonsterAttackStrategy(){

    }

    @Override
    public void selectAction(){
        int r = random.nextInt(2) + 1;

        if(r == 1){
            character.setAction(Action.ATTACK);
        } else {
            character.setAction(Action.DEFEND);
        }
    }
}
