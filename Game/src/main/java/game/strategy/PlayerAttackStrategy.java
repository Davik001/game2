package game.strategy;

import game.character.Action;
import game.character.Character;

import java.util.Scanner;

public class PlayerAttackStrategy extends AbstractChooseStrategy {

    public PlayerAttackStrategy(Character character){
        this.character = character;
    }

    public PlayerAttackStrategy(){

    }

    @Override
    public void selectAction() {
        Scanner scanner = new Scanner(System.in);

        int pAct = scanner.nextInt();
        if(pAct == 1){
            character.setAction(Action.ATTACK);
        } else if(pAct == 2){
            character.setAction(Action.DEFEND);
        } else {
            System.out.println("Неккоректное действие...");
        }
    }
}
