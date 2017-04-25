package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Round {
    private int id;
    private int number;
    private int turn;
    private List<Question> questions = new ArrayList<>(3);
    private List<PlayerAnswers> playerAnswers = new ArrayList<>(2);

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

        AnswerSet answers = this.playerAnswers.stream()
                .filter(a -> a.getPlayer().equals(player))
                .map(a -> a.getAnswerSet())
                .collect(Collectors.toList())
                .get(0);
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

    @OneToMany
    public List<PlayerAnswers> getPlayerAnswers() {
        return playerAnswers;
    }

    public void setPlayerAnswers(List<PlayerAnswers> playerAnswers) {
        this.playerAnswers = playerAnswers;
    }
}
