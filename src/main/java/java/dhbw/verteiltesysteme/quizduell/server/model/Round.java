package java.dhbw.verteiltesysteme.quizduell.server.model;

import java.util.*;

/**
 * Created by Dodo on 30.03.2017.
 */
public class Round {
    private int round;
    private int turn;
    private Question[] questions = new Question[3];
    private HashMap<Player, AnswerSet> playerAnswers = new HashMap<>(3);

    public Round(int round, Collection<String> questions) {
        this.round = round;
        this.questions = questions.toArray(this.questions);
    }

    public provideAnswer(Player player, Answer answer) {
        AnswerSet answers = this.playerAnswers.get(player);
        answers.add(answer);
    }
}
