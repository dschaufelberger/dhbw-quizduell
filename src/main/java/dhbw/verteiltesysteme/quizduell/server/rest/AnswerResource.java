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
        String gameId = getAttribute("gameId");
        String roundNum = getAttribute("roundNum");
        String turnNum = getAttribute("turnNum");

        EntityManager entityManager = Database.INSTANCE.getEntityManager();
        GameRoom gameRoom = entityManager.find(GameRoom.class, Integer.parseInt(gameId));

        if (gameRoom == null) {
            return;
        }

        Round round = gameRoom.getMatch().getRound(Integer.parseInt(roundNum));
        if (round == null) {
            return;
        }

        if (round.getTurn() == Integer.parseInt(turnNum)) {
            JacksonRepresentation<AnswerRepresentation> jsonAnswer = new JacksonRepresentation<>(representation, AnswerRepresentation.class);
            AnswerRepresentation answerRepresentation = jsonAnswer.getObject();
            Player player = gameRoom.getPlayerByName(answerRepresentation.playerName);
            Answer answer = round.getQuestions().get(0).getAnswers().get(answerRepresentation.number);
            round.provideAnswer(player, answer, Integer.parseInt(turnNum));
        }
    }
}
