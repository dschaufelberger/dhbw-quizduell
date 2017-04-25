package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AnswerSet {
    private int id;
    private List<Answer> answers = new ArrayList<>(3);

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

    public void add(Answer answer) {
        if (!this.isComplete()) {
            answers.add(answer);
        }
    }

    @OneToMany
    public List<Answer> getAnswers() {
        return new ArrayList<>(this.answers);
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
