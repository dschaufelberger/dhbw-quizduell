package dhbw.verteiltesysteme.quizduell.server.rest;

import dhbw.verteiltesysteme.quizduell.server.model.*;
import dhbw.verteiltesysteme.quizduell.server.rest.representations.AnswerRepresentation;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.io.IOException;

public class AnswerResource extends ServerResource {

    @Put
    public void sendAnswer(Representation representation) throws IOException {
        String gameIdAttribute = getAttribute("gameId");
        String roundNumAttribute = getAttribute("roundNum");
        String turnNumAttribute = getAttribute("turnNum");

        EntityManager entityManager = Database.INSTANCE.getEntityManager();
        GameRoom gameRoom = entityManager.find(GameRoom.class, Integer.parseInt(gameIdAttribute));

        if (gameRoom == null) {
            return;
        }

        int roundNumber = Integer.parseInt(roundNumAttribute);
        Round current = gameRoom.getCurrentRound();
        if (current.getNumber() != roundNumber) {
            return;
        }

        int turnNumber = Integer.parseInt(turnNumAttribute);

        if (current.getTurn() == turnNumber) {
            JacksonRepresentation<AnswerRepresentation> jsonAnswer = new JacksonRepresentation<>(representation, AnswerRepresentation.class);
            AnswerRepresentation answerRepresentation = jsonAnswer.getObject();
            Player player = gameRoom.getPlayerByName(answerRepresentation.playerName);
            Answer answer = current.getQuestions().get(0).getAnswers().get(answerRepresentation.number);

            entityManager.getTransaction().begin();

            current.provideAnswer(player, answer);
            entityManager.persist(gameRoom);

            entityManager.getTransaction().commit();
        }
    }
}
