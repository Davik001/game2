package game.area;

import game.character.Character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Location {

    private String name;
    private String description;
    private List<Character> monsters = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    private boolean isVisit = true;

    public Location(String name, String description){
        this.name = name;
        this.description = description;
        this.locations = new ArrayList<>();
        this.monsters = new ArrayList<>();
    }

    public Location(){}


    public int getCountOfLocations(){
        return locations.size();
    }

    public void addLocation(Location location){
        locations.add(location);
    }


    public boolean locationCheck(int chooseLocation){
        if(chooseLocation < 1 || chooseLocation > getCountOfLocations()){
            return false;
        } else {
            return true;
        }
    }

    public void addMonster(Character character){
        monsters.add(character);
    }

    public Location getLocation(int index){
        if(index >= 0 && index < locations.size()) {
            return locations.get(index);
        } else {
            throw new IndexOutOfBoundsException("Неверный номер локации");
        }
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public boolean isVisitPlace(){
        return isVisit;
    }

    public void showLocations() {
        for (int i = 0; i < locations.size(); i++) {
            Location location = locations.get(i);
            System.out.println((i + 1) + ". " + location.getName() + " - " + location.getDescription());
        }
    }

    public List<Character> getMonsters() {
        return monsters;
    }

    public boolean markVisit(int choosenLocation){
        if(choosenLocation < 1 && choosenLocation > locations.size()){
            isVisit = false;
        } else {
            isVisit = true;
        }
        return isVisit;
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
