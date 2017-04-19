package dhbw.verteiltesysteme.quizduell.server.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnswerSet {
    private int id;
    private List<Answer> answers = new ArrayList<>(3);

    public int getAnswerCount() {
        return this.answers.size();
    }

    public boolean isComplete() {
        return this.getAnswerCount() == 3;
    }

    public void add(Answer answer) {
        if (!this.isComplete()) {
            answers.add(answer);
        }
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(this.answers);
    }
}
