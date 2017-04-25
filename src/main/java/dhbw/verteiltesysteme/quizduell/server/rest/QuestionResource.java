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
        String gameId = getAttribute("gameId");
        String roundNum = getAttribute("roundNum");
        String turnNum = getAttribute("turnNum");

        EntityManager entityManager = Database.INSTANCE.getEntityManager();
        GameRoom gameRoom = entityManager.find(GameRoom.class, Integer.parseInt(gameId));

        if (gameRoom == null) {
            return new EmptyRepresentation();
        }

        Round round = gameRoom.getMatch().getRound(Integer.parseInt(roundNum));
        if (round == null) {
            return new EmptyRepresentation();
        }

        if (round.getTurn() == Integer.parseInt(turnNum)) {
            return new JacksonRepresentation<QuestionRepresentation>(new QuestionRepresentation(round.getQuestions().get(round.getTurn() - 1)));
        }

        return new EmptyRepresentation();
    }
}
