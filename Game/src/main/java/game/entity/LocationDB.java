package game.entity;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "location")
public class LocationDB {

    @Id
    @Column(name = "name", unique = true, nullable = false, columnDefinition = "Unknown location..")
    String name;

    @Column(name = "description")
    String description;

    public LocationDB() {}

    public LocationDB(String name, String description) {
        this.name = name;
        this.description = description;
    }


    @ManyToMany
    @JoinTable(
            name = "location_link",
            joinColumns = @JoinColumn(name = "from_location", referencedColumnName = "name"),
            inverseJoinColumns = @JoinColumn(name = "to_location", referencedColumnName = "name")
    )
    Set<LocationDB> locations;

    // геттеры
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}


