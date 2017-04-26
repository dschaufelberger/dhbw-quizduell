package dhbw.verteiltesysteme.quizduell.server.rest;

import dhbw.verteiltesysteme.quizduell.server.model.Database;
import dhbw.verteiltesysteme.quizduell.server.model.GameRoom;
import dhbw.verteiltesysteme.quizduell.server.model.Round;
import dhbw.verteiltesysteme.quizduell.server.rest.representations.QuestionRepresentation;
import org.apache.log4j.Logger;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;

/**
 * Created by Dodo on 20.04.2017.
 */
public class QuestionResource extends ServerResource {
    Logger logger = Logger.getLogger("QuestionResource");

    @Get
    public Representation getCurrentTurnQuestion() {
        String gameIdAttribute = getAttribute("gameId");
        String roundNumAttribute = getAttribute("roundNum");
        String turnNumAttribute = getAttribute("turnNum");

        EntityManager entityManager = Database.INSTANCE.getEntityManager();
        GameRoom gameRoom = entityManager.find(GameRoom.class, Integer.parseInt(gameIdAttribute));

        if (gameRoom == null) {
            return new EmptyRepresentation();
        }

        int roundNumber = Integer.parseInt(roundNumAttribute);
        Round current = gameRoom.getCurrentRound();
        if (current.getNumber() != roundNumber) {
            return new EmptyRepresentation();
        }

        int turnNumber = Integer.parseInt(turnNumAttribute);

        if (current.getTurn() == turnNumber) {
            return new JacksonRepresentation<>(new QuestionRepresentation(current.getQuestions().get(current.getTurn() - 1)));
        }

        return new EmptyRepresentation();
    }
}
