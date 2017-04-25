package dhbw.verteiltesysteme.quizduell.server.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Question {
    private int id;
    private String text;
    private String topic;
    private Map<Integer, Answer> answers = new HashMap<>(4);
    private Answer solution;

    public Question(String text, String topic, Collection<Answer> answers, Answer solution) {
        this.text = text;
        this.topic = topic;
        this.solution = solution;

        for (Answer answer : answers) {
            this.answers.put(answer.getNumber(), answer);
        }
    }

    public boolean isCorrect(Answer answer) {
        return this.solution.equals(answer);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @OneToMany
    @MapKeyColumn(name = "number")
    public Map<Integer, Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, Answer> answers) {
        this.answers = answers;
    }
}
