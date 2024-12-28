package game.character;

import game.area.Location;
import game.strategy.MonsterAttackStrategy;
import java.util.Scanner;

public class Player extends Character {
    private Scanner scanner = new Scanner(System.in);
    private Location currentLocation = new Location();
    private String name;


    public Player(int h, int a, int d){
        super(h, a, d); // используем конструктор родительского класса
    }

    public Player(){}

    public Location getCurrentLocation(){
        return currentLocation;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    @Override
    protected void printDefend() {
        System.out.println("Игрок защищается!");
    }

    @Override
    protected void printAttack(int damage) {
        System.out.println("Игрок атакует! Нанесено " + damage + " урона");
    }

    @Override
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void chooseLoc() {

        if (currentLocation.getCountOfLocations() == 0) {
            throw new Error("Нештатная ситуация! Карта неправильно спроектировна..");
        }

        System.out.println("Доступные локации:");
        currentLocation.showLocations();

        System.out.println("Выберите локацию:");
        int chooseLocation = scanner.nextInt();

        // Проверка выбора локации
        if (!currentLocation.locationCheck(chooseLocation)) {
            System.out.println("Неверный выбор. Попробуйте еще раз.");
            return;
        }

        Location selectedLocation = currentLocation.getLocation(chooseLocation - 1);
        System.out.println("Вы выбрали локацию: " + selectedLocation.getName());
        System.out.println("Описание: " + selectedLocation.getDescription());

        // Устанавливаем выбранную локацию как текущую
        currentLocation = selectedLocation;
    }
}
