package game.entity;
import jakarta.persistence.*;

@Entity
public class MonsterDB {

    @Id
    @Column(unique=true, nullable=false)
    String name;

    @Column
    int attack;
    @Column
    int defense;
    @Column
    int health;

    @ManyToOne
    @JoinColumn(name = "location_name", referencedColumnName = "name", nullable = false)
    private LocationDB location;

    public MonsterDB() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public LocationDB getLocation() {
        return location;
    }

    public void setLocation(LocationDB location) {
        this.location = location;
    }

}
