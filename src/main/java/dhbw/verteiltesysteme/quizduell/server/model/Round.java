package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Entity
public class Round {
    private int id;
    private int round;
    private int turn;
    private List<Question> questions = new ArrayList<>(3);
    private HashMap<Player, AnswerSet> playerAnswers = new HashMap<>(3);

    public Round(int round, Collection<Question> questions) {
        this.round = round;
        this.questions = new ArrayList<>(questions);
    }

    public void provideAnswer(Player player, Answer answer) {
        AnswerSet answers = this.playerAnswers.get(player);
        answers.add(answer);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Transient
    public HashMap<Player, AnswerSet> getPlayerAnswers() {
        return playerAnswers;
    }

    public void setPlayerAnswers(HashMap<Player, AnswerSet> playerAnswers) {
        this.playerAnswers = playerAnswers;
    }
}
