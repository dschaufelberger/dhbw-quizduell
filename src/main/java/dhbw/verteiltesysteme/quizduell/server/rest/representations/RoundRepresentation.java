package dhbw.verteiltesysteme.quizduell.server.rest.representations;

import dhbw.verteiltesysteme.quizduell.server.model.AnswerSet;
import dhbw.verteiltesysteme.quizduell.server.model.Player;
import dhbw.verteiltesysteme.quizduell.server.model.PlayerAnswers;
import dhbw.verteiltesysteme.quizduell.server.model.Round;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dodo on 19.04.2017.
 */
public class RoundRepresentation {
    public int round;
    public Map<String, Integer> answersPerPlayer = new HashMap<>(2);

    public RoundRepresentation(Round round) {
        this.round = round.getNumber();
        List<PlayerAnswers> playerAnswers = round.getPlayerAnswers();

        for (PlayerAnswers answers : playerAnswers) {
            this.answersPerPlayer.put(answers.getPlayer().getName(), answers.getAnswerSet().getAnswerCount());
        }
    }
}
