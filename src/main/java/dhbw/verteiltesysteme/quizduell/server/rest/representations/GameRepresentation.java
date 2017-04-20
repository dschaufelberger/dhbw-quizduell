package dhbw.verteiltesysteme.quizduell.server.rest.representations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dhbw.verteiltesysteme.quizduell.server.model.GameRoom;
import dhbw.verteiltesysteme.quizduell.server.model.GameState;

@JsonIgnoreProperties("NON_EXISTING")
public class GameRepresentation {
    public int id;
    public int currentRound;
    public String player1;
    public String player2;
    public GameState state;

    public static GameRepresentation notExisting() {
        return GameRepresentation.from(null);
    }

    public static GameRepresentation from(GameRoom gameRoom) {
        int gameId = 0;
        GameState state = GameState.NONE;
        GameRepresentation game = new GameRepresentation();

        if (gameRoom != null) {
            game.id = gameRoom.getGameId();
            game.state = gameRoom.getState();
            game.currentRound = gameRoom.getCurrentRound().getNumber();
            game.player1 = gameRoom.getPlayer1() == null ? "" : gameRoom.getPlayer1().getName();
            game.player2 = gameRoom.getPlayer2() == null ? "" : gameRoom.getPlayer2().getName();
        }

        return game;
    }

    private GameRepresentation() {
        this.state = GameState.NONE;
    }
}
