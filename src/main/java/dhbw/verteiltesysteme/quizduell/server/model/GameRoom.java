package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;

@Entity
public class GameRoom {
    private int gameId;
    private Player player1;
    private Player player2;
    private GameState state;
    private Match match;

    public GameRoom() {
        this.state = GameState.CREATED;
    }

    @Transient
    public Round getCurrentRound() {
        return this.match.getNextRound();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Enumerated(value = EnumType.STRING)
    public GameState getState() {
        return state;
    }
    public void setState(GameState state) {
        this.state = state;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void startGame() {
        if (getPlayer1() == null || getPlayer2() == null) {
            return;
        }

        this.match = new Match();
        this.state = GameState.STARTED;
    }
}
