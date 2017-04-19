package dhbw.verteiltesysteme.quizduell.server.rest.representations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dhbw.verteiltesysteme.quizduell.server.model.GameRoom;
import dhbw.verteiltesysteme.quizduell.server.model.GameState;

@JsonIgnoreProperties("NON_EXISTING")
public class GameRepresentation {
    public int id;
    public int currentRound;
    public GameState state;

    public static GameRepresentation notExisting() {
        return GameRepresentation.from(null);
    }

    public static GameRepresentation from(GameRoom gameRoom) {
        int gameId = 0;
        int currentRound = 0;
        GameState state = GameState.NONE;
        if (gameRoom != null) {
            gameId = gameRoom.getGameId();
            state = gameRoom.getState();
            currentRound = gameRoom.getCurrentRound().getNumber();
        }
        return new GameRepresentation(gameId, state, currentRound);
    }

    private GameRepresentation(int id, GameState state, int currentRound) {
        this.id = id;
        this.state = state;
        this.currentRound = currentRound;
    }
}
