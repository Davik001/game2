package game.session;

import game.area.Location;
import game.character.Player;
import game.entity.LocationDB;
import game.entity.PlayerDB;

public class PlayerMapper {

    // из Plyaer в PlayerDB
    public static PlayerDB mapToPlayerDB(Player player) {
        if (player == null) {
            return null;
        }

        PlayerDB playerDB = new PlayerDB();
        playerDB.setName(player.getName());
        playerDB.setHealth(player.getHealth());
        playerDB.setAttack(player.getAttack());
        playerDB.setDefense(player.getDefense());

        // Преобразование текущей локации
        Location currentLocation = player.getCurrentLocation();
        if (currentLocation != null) {
            LocationDB locationDB = new LocationDB();
            locationDB.setName(currentLocation.getName());
            locationDB.setDescription(currentLocation.getDescription());
            playerDB.setCurrentLocation(locationDB);
        }

        return playerDB;
    }

    // из Player в PlayerDB
    public static Player mapToPlayer(PlayerDB playerDB) {
        if (playerDB == null) {
            return null;
        }

        Player player = new Player();
        player.setHealth(playerDB.getHealth());
        player.setAttack(playerDB.getAttack());
        player.setDefense(playerDB.getDefense());

        // Преобразование текущей локации
        LocationDB currentLocationDB = playerDB.getCurrentLocation();
        if (currentLocationDB != null) {
            Location currentLocation = new Location();
            currentLocation.setName(currentLocationDB.getName());
            currentLocation.setDescription(currentLocationDB.getDescription());
            player.setCurrentLocation(currentLocation);
        }

        return player;
    }
}
