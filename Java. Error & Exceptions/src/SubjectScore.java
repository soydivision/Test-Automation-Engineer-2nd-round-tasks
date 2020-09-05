
public class SubjectScore {
    private Enum subject;
    private int mark;

    public SubjectScore(Enum subject, int mark) {
        this.subject = subject;
    }

    public Enum getSubject() {
        return subject;
    }

    public void setSubject() {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }
}