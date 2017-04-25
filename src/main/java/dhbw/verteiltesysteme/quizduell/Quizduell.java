package dhbw.verteiltesysteme.quizduell;

import dhbw.verteiltesysteme.quizduell.server.rest.GameResource;
import dhbw.verteiltesysteme.quizduell.server.rest.QuestionResource;
import dhbw.verteiltesysteme.quizduell.server.rest.RegistrationResource;
import dhbw.verteiltesysteme.quizduell.server.rest.RoundResource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;


public class Quizduell extends Application{
    public void startServer(int port) throws Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, port);
        component.getDefaultHost().attach(this);
        component.start();
    }

    @Override
    public Restlet getInboundRoot() {
        Router router = new Router(getContext());

        router.attach("/game/{gameId}", GameResource.class);
        router.attach("/game/{gameId}/round", RoundResource.class);
        router.attach("/game/{gameId}/round/{roundId}/question", QuestionResource.class);
        router.attach("/enter", RegistrationResource.class);

        return router;
    }

    public static void main(String[] args) throws Exception {
        Quizduell quizduellApp = new Quizduell();
        quizduellApp.startServer(80);
    }
}
