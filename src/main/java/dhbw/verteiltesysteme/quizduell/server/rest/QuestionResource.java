package dhbw.verteiltesysteme.quizduell.server.rest;

import dhbw.verteiltesysteme.quizduell.server.model.Database;
import org.apache.log4j.Logger;
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
        EntityManager entityManager = Database.INSTANCE.getEntityManager();

        String gameId = getAttribute("blabla");
        logger.debug(gameId);

        return new EmptyRepresentation();
    }
}
