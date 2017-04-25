package dhbw.verteiltesysteme.quizduell.server.rest.representations;

import dhbw.verteiltesysteme.quizduell.server.model.Answer;
import dhbw.verteiltesysteme.quizduell.server.model.Question;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Dodo on 20.04.2017.
 */
public class QuestionRepresentation {
    public String text;
    public Map<String, String> answers = new HashMap<>(4);

    public QuestionRepresentation(Question question) {
        this.text = question.getText();

        for (Answer answer : question.getAnswers().values()) {
            this.answers.put(answer.getLetter(), answer.getText());
        }
    }
}
