package dhbw.verteiltesysteme.quizduell.server.rest;

import dhbw.verteiltesysteme.quizduell.server.model.Database;
import dhbw.verteiltesysteme.quizduell.server.model.GameRoom;
import dhbw.verteiltesysteme.quizduell.server.rest.representations.GameRepresentation;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.util.Map;

public class GameResource extends ServerResource {

    @Get
    public Representation retrieveInformation() {
        Map<String, Object> request = getRequestAttributes();
        if (request.containsKey("id")) {
            EntityManager entityManager = Database.INSTANCE.getEntityManager();
            GameRoom gameRoom = entityManager.find(GameRoom.class, Integer.parseInt(request.get("id").toString()));
            return new JacksonRepresentation<GameRepresentation>(GameRepresentation.from(gameRoom));
        }

        return new JacksonRepresentation<GameRepresentation>(GameRepresentation.notExisting());
    }
}
