package dhbw.verteiltesysteme.quizduell.server.model;

public class Answer {
    private int id;
    private String text;
    private boolean isCorrect;

    private Answer(int id, String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    protected int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (isCorrect != answer.isCorrect) return false;
        return text.equals(answer.text);

    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + (isCorrect ? 1 : 0);
        return result;
    }
}
