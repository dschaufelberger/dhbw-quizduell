package dhbw.verteiltesysteme.quizduell.server.rest.representations;

import dhbw.verteiltesysteme.quizduell.server.model.Answer;
import dhbw.verteiltesysteme.quizduell.server.model.Player;

public class AnswerRepresentation {
    public boolean isCorrect;
    public int number;
    public String playerName;

    public AnswerRepresentation() {

    }

    public AnswerRepresentation(Answer answer, Player player) {
        this.isCorrect = answer.isCorrect();
        this.number = answer.getNumber();
        this.playerName = player.getName();
    }
}
