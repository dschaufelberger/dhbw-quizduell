package dhbw.verteiltesysteme.quizduell.server.rest.representations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dhbw.verteiltesysteme.quizduell.server.model.GameRoom;
import dhbw.verteiltesysteme.quizduell.server.model.GameState;

@JsonIgnoreProperties("NON_EXISTING")
public class GameRepresentation {
    public int id;
    public GameState state;

    public static GameRepresentation notExisting() {
        return GameRepresentation.from(null);
    }

    public static GameRepresentation from(GameRoom gameRoom) {
        int gameId = 0;
        GameState state = GameState.NONE;
        if (gameRoom != null) {
            gameId = gameRoom.getGameId();
            state = gameRoom.getState();
        }
        return new GameRepresentation(gameId, state);
    }

    private GameRepresentation(int id, GameState state) {
        this.id = id;
        this.state = state;
    }
}
