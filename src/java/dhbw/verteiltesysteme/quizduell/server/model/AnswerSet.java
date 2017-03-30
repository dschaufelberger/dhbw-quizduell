package java.dhbw.verteiltesysteme.quizduell.server.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dodo on 30.03.2017.
 */
public class AnswerSet {
    private List<Answer> answers = new ArrayList<>(3);

    public boolean isComplete() {
        return this.answers.size() == 3;
    }

    public void add(Answer answer) {
        if (!this.isComplete()) {
            answers.add(answer);
        }
    }

    public List<Answer> getAnswers() {

    }
}
