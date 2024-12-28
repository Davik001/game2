package game.session;

import game.character.Player;
import game.entity.PlayerDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GameSave {

    public void save(Player p) {
        PlayerDB playerDB = PlayerMapper.mapToPlayerDB(p);

       // playerDB.setName(p.getName());
        try(Session session = HibernateRunner.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(playerDB);
            tx.commit();
        } catch (Exception e) {
            System.err.println("Ошибка при сохранении игры: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Player download(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }

        PlayerDB playerDB;

        try(Session session = HibernateRunner.getSessionFactory().openSession()) {
            playerDB = session.get(PlayerDB.class, name);

            if (playerDB == null) {
                System.err.println("Игрок с именем " + name + " не найден.");
                return null;
            }

            return PlayerMapper.mapToPlayer(playerDB);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }

}