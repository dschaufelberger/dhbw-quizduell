package dhbw.verteiltesysteme.quizduell.server.rest.representations;

import dhbw.verteiltesysteme.quizduell.server.model.GameRoom;
import dhbw.verteiltesysteme.quizduell.server.model.Player;

public class RegistrationRepresentation {
    public int gameId;
    public String playerName;

    public RegistrationRepresentation(Player player, GameRoom game) {
        this.gameId = game.getGameId();
        this.playerName = player.getName();
    }
}
