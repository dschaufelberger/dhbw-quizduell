package dhbw.verteiltesysteme.quizduell.server.rest;

import dhbw.verteiltesysteme.quizduell.server.model.Database;
import dhbw.verteiltesysteme.quizduell.server.model.GameRoom;
import dhbw.verteiltesysteme.quizduell.server.model.Round;
import dhbw.verteiltesysteme.quizduell.server.rest.representations.RoundRepresentation;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Dodo on 19.04.2017.
 */
public class RoundResource extends ServerResource {
    @Get
    public Representation getRoundInformation() {
        String gameId = getAttribute("gameId");
        String roundNum = getAttribute("roundNum");

        EntityManager entityManager = Database.INSTANCE.getEntityManager();
        GameRoom gameRoom = entityManager.find(GameRoom.class, Integer.parseInt(gameId));

        if (gameRoom == null) {
            return new EmptyRepresentation();
        }

        Round round = gameRoom.getMatch().getRound(Integer.parseInt(roundNum));
        if (round == null) {
            return new EmptyRepresentation();
        }

        return new JacksonRepresentation<>(new RoundRepresentation(round));
    }
}
