package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class AnswerSet {
    private int id;
    private Map<Integer, Answer> answers = new HashMap(3);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Transient
    public int getAnswerCount() {
        return this.answers.size();
    }

    @Transient
    public boolean isComplete() {
        return this.getAnswerCount() == 3;
    }

    public void add(Answer answer, int turn) {
        if (!this.isComplete()) {
            this.answers.put(turn, answer);
        }
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Map<Integer, Answer> getAnswers() {
        return new HashMap<>(this.answers);
    }

    public void setAnswers(Map<Integer, Answer> answers) {
        this.answers = answers;
    }
}
