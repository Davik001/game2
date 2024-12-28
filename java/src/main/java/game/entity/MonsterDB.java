package game.entity;
import jakarta.persistence.*;

@Entity
public class MonsterDB {

    @Id
    @Column(unique=true, nullable=false)
    String name;

    int attack;
    int defense;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonsterDB monsterDB = (MonsterDB) o;

        return name.equals(monsterDB.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
