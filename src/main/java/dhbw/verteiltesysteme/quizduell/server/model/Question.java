package dhbw.verteiltesysteme.quizduell.server.model;

import java.util.Collection;
import java.util.HashMap;

public class Question {
    private String text;
    private String topic;
    private HashMap<Integer, Answer> answers;
    private Answer solution;

    public Question(String text, String topic, Collection<Answer> answers, Answer solution) {
        this.text = text;
        this.topic = topic;
        this.solution = solution;

        for (Answer answer : answers) {
            this.answers.put(answer.getId(), answer);
        }
    }

    public boolean answer(Answer answer) {
        return this.solution.equals(answer);
    }
}
