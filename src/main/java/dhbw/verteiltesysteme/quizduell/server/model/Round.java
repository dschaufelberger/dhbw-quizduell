package dhbw.verteiltesysteme.quizduell.server.model;

import java.util.*;

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
