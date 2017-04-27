package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "Game")
public class Match {
    public static final int MAX_ROUNDS = 6;
    public static final int MAX_QUESTIONS = 3;
    public static final int MAX_PLAYERS = 2;

    private int id;
    private int currentRoundNumber;
    private List<Round> rounds;

    public Match() {
        this(new ArrayList<>(MAX_ROUNDS));
    }

    public Match(List<Round> rounds) {
        this.rounds = rounds;
        this.currentRoundNumber = 1;
    }

    public void startNextRound() {
        if (this.currentRoundNumber < MAX_ROUNDS) {
            this.currentRoundNumber++;
        }
    }

    @Transient
    public Round getRound(int roundNumber) {
        List<Round> rounds = this.rounds.stream()
                .filter(round -> round.getNumber() == roundNumber)
                .collect(Collectors.toList());

        if (rounds.isEmpty()) {
            return null;
        }

        return rounds.get(0);
    }

    @Transient
    public Round getCurrentRound() {
        return getRound(getCurrentRoundNumber());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentRoundNumber() {
        return currentRoundNumber;
    }


    public void setCurrentRoundNumber(int currentRoundNumber) {
        this.currentRoundNumber = currentRoundNumber;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
