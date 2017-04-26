package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;

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
    public Player getPlayerByName(String name) {
        if (this.player1.getName().equals(name)) {
            return this.player1;
        }

        if (this.player2.getName().equals(name)) {
            return this.player2;
        }

        return null;
    }

    @Transient
    public Round getCurrentRound() {
        return this.match.getCurrentRound();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

        int capacity = 6;
        ArrayList<Round> rounds = new ArrayList<>(6);
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(getPlayer1());
        players.add(getPlayer2());

        for (int roundNumber = 1; roundNumber <= capacity; roundNumber++) {
            ArrayList<Answer> answers = new ArrayList<>(4);
            answers.add(new Answer("Ja", 1, true));
            answers.add(new Answer("Nein",2, false));
            answers.add(new Answer("Nö", 3,false));
            answers.add(new Answer("Nope",4, false));
            ArrayList<Answer> answers2 = new ArrayList<>(4);
            answers2.add(new Answer("Ja", 1, true));
            answers2.add(new Answer("Nein",2, false));
            answers2.add(new Answer("Nö", 3,false));
            answers2.add(new Answer("Nope",4, false));
            ArrayList<Answer> answers3 = new ArrayList<>(4);
            answers3.add(new Answer("Ja", 1, true));
            answers3.add(new Answer("Nein",2, false));
            answers3.add(new Answer("Nö", 3,false));
            answers3.add(new Answer("Nope",4, false));

            ArrayList<Question> questions = new ArrayList<>(3);
            questions.add(new Question("Siehst du mich?", "General", answers, answers.get(0)));
            questions.add(new Question("Siehst du mich?", "General", answers2, answers2.get(0)));
            questions.add(new Question("Siehst du mich?", "General", answers3, answers3.get(0)));

            rounds.add(new Round(roundNumber, questions, players));
        }

        this.match = new Match(rounds);
        this.state = GameState.STARTED;
    }
}
