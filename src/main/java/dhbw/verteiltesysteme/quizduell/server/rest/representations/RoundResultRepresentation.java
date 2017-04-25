package dhbw.verteiltesysteme.quizduell.server.rest.representations;

import dhbw.verteiltesysteme.quizduell.server.model.Answer;
import dhbw.verteiltesysteme.quizduell.server.model.AnswerSet;
import dhbw.verteiltesysteme.quizduell.server.model.Player;
import dhbw.verteiltesysteme.quizduell.server.model.Round;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundResultRepresentation {
    public Map<String, Map<Integer, Boolean>> answerResultsPerPlayer = new HashMap<>(2);

    public RoundResultRepresentation(Round round) {
        Map<Player, AnswerSet> answersPerPlayer = round.getPlayerAnswers();
        String playerName;
        for (Map.Entry<Player, AnswerSet> answersOfPlayer: answersPerPlayer.entrySet()) {
            playerName = answersOfPlayer.getKey().getName();
            HashMap<Integer, Boolean> answerResults = new HashMap<>(3);
            List<Answer> answers = answersOfPlayer.getValue().getAnswers();
            for (int i = 0; i < answers.size(); i++) {
                answerResults.put(i, answers.get(i).isCorrect());
            }

            this.answerResultsPerPlayer.put(playerName, answerResults);
        }
    }
}
