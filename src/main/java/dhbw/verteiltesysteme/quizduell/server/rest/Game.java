package dhbw.verteiltesysteme.quizduell.server.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dhbw.verteiltesysteme.quizduell.server.model.GameRoom;
import dhbw.verteiltesysteme.quizduell.server.model.GameState;

@JsonIgnoreProperties("NON_EXISTING")
public class Game {
    public int id;
    public GameState state;

    public static Game notExisting() {
        return Game.from(null);
    }

    public static Game from(GameRoom gameRoom) {
        int gameId = 0;
        GameState state = GameState.NONE;
        if (gameRoom != null) {
            gameId = gameRoom.getGameId();
            state = gameRoom.getState();
        }
        return new Game(gameId, state);
    }

    private Game(int id, GameState state) {
        this.id = id;
        this.state = state;
    }
}
