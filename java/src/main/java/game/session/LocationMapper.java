package game.session;

import game.area.Location;
import game.entity.LocationDB;
import game.entity.PlayerDB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LocationMapper {

    // Метод для преобразования Location в LocationDB
    public static LocationDB toLocationDB(Location location) {
        LocationDB locationDB = new LocationDB(location.getName(), location.getDescription());

        Set<LocationDB> DBSet = new HashSet<>();
        for (Location loc : location.getLocations()) {
            LocationDB locDB = new LocationDB(loc.getName(), loc.getDescription());
            DBSet.add(locDB);
        }
        locationDB.setLocations(DBSet);

        return locationDB;
    }

    // Метод для преобразования LocationDB в Location
    public static Location toLocation(LocationDB locationDB) {
        Location location = new Location(locationDB.getName(), locationDB.getDescription());

        Set<LocationDB> DBSet  = locationDB.getLocations();
        for (LocationDB locDB : DBSet ) {
            Location loc = new Location(locDB.getName(), locDB.getDescription());
            location.addLocation(loc);
        }

        return location;
    }


}
