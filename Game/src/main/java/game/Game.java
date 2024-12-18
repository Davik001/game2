package game;
import game.area.Location;
import game.character.*;
import game.session.GameSave;
import game.strategy.MonsterAttackStrategy;
import game.strategy.PlayerAttackStrategy;
import game.character.Character;

import java.util.*;
public class Game {

    public static void main(String[] args) {

        Player player = new Player(100, 100, 5);
        player.setStrategy(new PlayerAttackStrategy());

        generateLocations(player);

        GameSave gameSave = new GameSave();

        while (true) {

            player.chooseLoc();

            Location currentLocation = player.getCurrentLocation();
            List<Character> monsters = currentLocation.getMonsters();

            System.out.println();
            System.out.println("Монстр!! Битва начинается..");


            Iterator<Character> iterator = monsters.iterator();
            while (iterator.hasNext()){

                Character monster = iterator.next();
                while (player.isAlive() && monster.isAlive()) { // начало while

                    System.out.println();
                    System.out.println("Здоровье игрока: " + player.getHealth());
                    System.out.println("Здоровье " + monster.getName() + " : " + monster.getHealth());

                    System.out.println();

                    System.out.println("Игрок и монстр готовятся...");
                    System.out.println();
                    System.out.println("Действия игрока:\n1 - Атака\n2 - Защита");

                    player.chooseAction();
                    monster.chooseAction();

                    player.makeAct(monster);

                    System.out.println();
                    if (monster.isAlive()) {
                        monster.makeAct(player);
                    }

                } // конец while


                if (player.isAlive()) {
                    System.out.println("Вы победили врага: " + monster.getName());
                    System.out.println();
                    gameSave.saveGame(player);
                    iterator.remove();

                    //   gameSave.saveGame(player);

                    System.out.println("Продолжить бой или сохраниться ? \n1: Продолжить \n2: Сохраниться");
                    Scanner scanner = new Scanner(System.in);
                    int choice = scanner.nextInt();
                    if (choice == 2) {
                        System.out.println("Игра сохранена");
                        return;
                    }


                } else {
                    System.out.println("Вы проиграли..");
                    return;
                }
            } // итератор

        }
    }

    private static void generateLocations(Player player) {
        // Персонажи
        Character character2 = new Monster(100, 20, 10);
        Character character3 = new Rebounder(100, 15, 5, 2);
        Character character4 = new Furious(100, 10, 2, 2, 4);
        Character character5 = new Ravager(100, 10, 10, 2);

        // Стратегии персонажей
        character2.setStrategy(new MonsterAttackStrategy());
        character3.setStrategy(new MonsterAttackStrategy());
        character4.setStrategy(new MonsterAttackStrategy());
        character5.setStrategy(new MonsterAttackStrategy());

        // Локации
        Location derelictCastle = new Location("Заброшенный замок", "Замок стоит достаточно давно, в нем могли завестись монстры..");
        Location ruins = new Location("Руины", "Стены замка обрушились, оставив лишь обломки..");
        Location cave = new Location("Пещера", "Глубокая пещера, неизвестно, что тебя ждет..");
        Location forest = new Location("Лес", "В этом лесу можно встретить монстра..");

        // Добавление монстров в локации
        derelictCastle.addMonster(character3);
        ruins.addMonster(character2);
        cave.addMonster(character4);
        forest.addMonster(character5);

        // Добавление локаций игроку
        Location currentLocation = player.getCurrentLocation();
        currentLocation.addLocation(derelictCastle);
        currentLocation.addLocation(ruins);
        currentLocation.addLocation(cave);
        currentLocation.addLocation(forest);

        derelictCastle.addLocation(currentLocation);
        ruins.addLocation(currentLocation);
        cave.addLocation(currentLocation);
        forest.addLocation(currentLocation);
    }
}