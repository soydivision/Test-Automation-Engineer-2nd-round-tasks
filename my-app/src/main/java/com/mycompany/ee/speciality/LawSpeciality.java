package com.mycompany.ee.speciality;

import com.mycompany.ee.subjects.*;

import java.util.Arrays;
import java.util.List;

import static com.mycompany.ee.subjects.Subjects.LAW;

public class LawSpeciality extends Speciality {
    public static final String SPECIALITY = "law";
    private List<Subjects> lawCourse = Arrays.asList(
            Subjects.INTERNATIONAL_LAW,
            Subjects.LAW_HISTORY,
            LAW,
            Subjects.STATE_THEORY);

    public LawSpeciality() {
        super(SPECIALITY);
    }

    @Override
    public List<Subjects> getCourse() {
        return lawCourse;
    }
}
