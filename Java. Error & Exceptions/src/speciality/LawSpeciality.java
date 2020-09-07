package speciality;

import studentsubjects.*;

import java.util.Arrays;
import java.util.List;

public class LawSpeciality extends Speciality {
    public static final String SPECIALITY = "law";
    private List<StudentSubjects> lawCourse = Arrays.asList(
            StudentSubjects.INTERNATIONAL_LAW,
            StudentSubjects.LAW_HISTORY,
            StudentSubjects.LAW,
            StudentSubjects.STATE_THEORY)
}

    public LawSpeciality() {
        super(SPECIALITY);
    }

    @Override
    public List<StudentSubjects> getCourse() {
        return lawCourse;
    }
}