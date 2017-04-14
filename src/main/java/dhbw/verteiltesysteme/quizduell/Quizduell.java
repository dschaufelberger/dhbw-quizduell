package dhbw.verteiltesysteme.quizduell;

import dhbw.verteiltesysteme.quizduell.server.model.GameRoom;
import dhbw.verteiltesysteme.quizduell.server.model.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Quizduell {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("emf");
        EntityManager entityManager = factory.createEntityManager();

        GameRoom gameRoom = new GameRoom();
        Player p1 = new Player(Player.generateRandomName());
        Player p2 = new Player(Player.generateRandomName());
        gameRoom.setPlayer1(p1);
        gameRoom.setPlayer2(p2);

        entityManager.getTransaction().begin();
        entityManager.persist(gameRoom);
        entityManager.getTransaction().commit();
    }
}
