package speciality;

import subjects.*;

import java.util.Arrays;
import java.util.List;

public class LawSpeciality extends Speciality {
    public static final String SPECIALITY = "law";
    private List<Subjects> lawCourse = Arrays.asList(
            Subjects.INTERNATIONAL_LAW,
            Subjects.LAW_HISTORY,
            Subjects.LAW,
            Subjects.STATE_THEORY);

    public LawSpeciality() {
        super(SPECIALITY);
    }

    @Override
    public List<Subjects> getCourse() {
        return lawCourse;
    }
}
