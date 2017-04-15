package dhbw.verteiltesysteme.quizduell.server.rest;

import dhbw.verteiltesysteme.quizduell.server.model.Database;
import dhbw.verteiltesysteme.quizduell.server.model.GameRoom;
import dhbw.verteiltesysteme.quizduell.server.model.Player;
import dhbw.verteiltesysteme.quizduell.server.rest.representations.RegistrationRepresentation;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class RegistrationResource extends ServerResource{
    @Post
    public Representation registerPlayer() {
        EntityManager entityManager = Database.INSTANCE.getEntityManager();
        Player player = new Player(Player.generateRandomName());

        entityManager.getTransaction().begin();
        entityManager.persist(player);
        //entityManager.flush();

        TypedQuery<GameRoom> query = entityManager.createQuery("SELECT g FROM GameRoom g WHERE player1_id IS NULL OR player2_id IS NULL", GameRoom.class);
        List<GameRoom> openRooms = query.getResultList();
        GameRoom room;

        if (openRooms.isEmpty()) {
            room = new GameRoom();
            room.setPlayer1(player);
        } else {
            room = openRooms.get(0);

            if (room.getPlayer1() == null) {
                room.setPlayer1(player);
            } else {
                room.setPlayer2(player);
            }
        }

        entityManager.persist(room);
        entityManager.getTransaction().commit();

        return new JacksonRepresentation<RegistrationRepresentation>(new RegistrationRepresentation(player, room));
    }
}
