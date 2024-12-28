package game.strategy;

import game.character.Character;

public abstract class AbstractChooseStrategy {
    protected Character character;

    public abstract void selectAction();

    public void setCharacter(Character character){
        this.character = character;
    }

}
