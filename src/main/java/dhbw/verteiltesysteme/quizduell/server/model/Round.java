package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Entity
public class Round {
    private int id;
    private int number;
    private int turn;
    private List<Question> questions = new ArrayList<>(3);
    private HashMap<Player, AnswerSet> playerAnswers = new HashMap<>(3);

    public Round() {
    }

    public Round(int number, Collection<Question> questions) {
        this.number = number;
        this.questions = new ArrayList<>(questions);
        this.turn = 1;
    }

    public void provideAnswer(Player player, Answer answer) {
        if (turn > 3) {
            return;
        }

        AnswerSet answers = this.playerAnswers.get(player);
        answers.add(answer);
        this.turn++;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
