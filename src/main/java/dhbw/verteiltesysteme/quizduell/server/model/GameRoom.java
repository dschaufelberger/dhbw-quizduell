package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dodo on 30.03.2017.
 */
@Entity
public class GameRoom {
    private int gameId;
    private List<Round> rounds;
    private Player player1;
    private Player player2;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    @ManyToOne
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    @ManyToOne
    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
