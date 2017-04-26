package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;

@Entity
public class PlayerAnswers {
    private int id;
    private Player player;
    private AnswerSet answerSet;

    public PlayerAnswers() {
    }

    public PlayerAnswers(Player player) {
        this.player = player;
        this.answerSet = new AnswerSet();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public AnswerSet getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(AnswerSet answerSet) {
        this.answerSet = answerSet;
    }
}
