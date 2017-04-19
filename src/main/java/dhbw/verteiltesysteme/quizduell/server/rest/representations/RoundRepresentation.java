package dhbw.verteiltesysteme.quizduell.server.rest.representations;

import dhbw.verteiltesysteme.quizduell.server.model.AnswerSet;
import dhbw.verteiltesysteme.quizduell.server.model.Player;
import dhbw.verteiltesysteme.quizduell.server.model.Round;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dodo on 19.04.2017.
 */
public class RoundRepresentation {
    public int id;
    public Map<String, Integer> answersPerPlayer = new HashMap<>(2);

    public RoundRepresentation(Round round) {
        this.id = round.getId();
        HashMap<Player, AnswerSet> answers = round.getPlayerAnswers();

        for (Player key : answers.keySet()) {
            this.answersPerPlayer.put(key.getName(), answers.get(key).getAnswerCount());
        }
    }
}
