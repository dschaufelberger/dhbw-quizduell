package dhbw.verteiltesysteme.quizduell;

import dhbw.verteiltesysteme.quizduell.server.model.Answer;
import dhbw.verteiltesysteme.quizduell.server.model.Database;
import dhbw.verteiltesysteme.quizduell.server.model.Question;
import dhbw.verteiltesysteme.quizduell.server.rest.*;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

import javax.persistence.EntityManager;
import java.util.ArrayList;


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
        router.attach("/game/{gameId}/round/{roundNum}", RoundResource.class);
        router.attach("/game/{gameId}/round/{roundNum}/result", RoundResultResource.class);
        router.attach("/game/{gameId}/round/{roundNum}/turn/{turnNum}/question", QuestionResource.class);
        router.attach("/enter", RegistrationResource.class);

        return router;
    }

    public static void main(String[] args) throws Exception {
        int onPort = 80;
        if (args.length > 0) {
            onPort = Integer.parseInt(args[0]);
        }

        Quizduell quizduellApp = new Quizduell();
        quizduellApp.startServer(onPort);
    }
}
