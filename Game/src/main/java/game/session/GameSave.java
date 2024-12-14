package game.session;

import game.character.Player;
import game.entity.PlayerDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GameSave {

    public void saveGame(Player p) {
        PlayerDB playerDB = PlayerMapper.mapToPlayerDB(p);

        try(Session session = HibernateRunner.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(playerDB);
            tx.commit();
        } catch (Exception e) {
        System.err.println("Ошибка при сохранении игры: " + e.getMessage());
        e.printStackTrace();
    }

    }
}