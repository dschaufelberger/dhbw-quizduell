package dhbw.verteiltesysteme.quizduell.server.rest.representations;

import dhbw.verteiltesysteme.quizduell.server.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundResultRepresentation {
    public Map<String, Map<Integer, Boolean>> answerResultsPerPlayer = new HashMap<>(2);

    public RoundResultRepresentation(Round round) {
        List<PlayerAnswers> answersPerPlayer = round.getPlayerAnswers();
        String playerName;
        for (PlayerAnswers answersOfPlayer : answersPerPlayer) {
            playerName = answersOfPlayer.getPlayer().getName();
            HashMap<Integer, Boolean> answerResults = new HashMap<>(3);
            Map<Integer, Answer> answers = answersOfPlayer.getAnswerSet().getAnswers();
            for (int i = 1; i <= answers.size(); i++) {
                answerResults.put(i, answers.get(i).isCorrect());
            }

            this.answerResultsPerPlayer.put(playerName, answerResults);
        }
    }
}
