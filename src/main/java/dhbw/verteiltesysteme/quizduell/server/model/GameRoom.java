package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GameRoom {
    private int gameId;
    private Player player1;
    private Player player2;
    private Match match;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
