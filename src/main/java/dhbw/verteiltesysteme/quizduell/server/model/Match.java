package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Game")
public class Match {
    private int id;
    private int currentRound;
    private List<Round> rounds;

    public Match() {
        this(new ArrayList<Round>(6));
        this.currentRound = 1;
    }

    public Match(List<Round> rounds) {
        this.rounds = rounds;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
