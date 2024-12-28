package game.entity;
import jakarta.persistence.*;

@Entity
//@Table(name = "player")
public class PlayerDB {

    @Id
    String name;

    int health;
    int attack;
    int defense;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    LocationDB currentLocation;

    public PlayerDB() {}

    // геттеры имени
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // здоровья
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    // атаки
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }

    // защиты
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    // локация
    public LocationDB getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentLocation(LocationDB currentLocation) {
        this.currentLocation = currentLocation;
    }
}