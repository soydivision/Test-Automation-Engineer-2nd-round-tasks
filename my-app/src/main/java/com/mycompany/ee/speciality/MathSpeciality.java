package com.mycompany.ee.speciality;

import com.mycompany.ee.subjects.Subjects;

import java.util.Arrays;
import java.util.List;

public class MathSpeciality extends Speciality {
    public static final String SPECIALITY = "math";
    private List<Subjects> mathCourse = Arrays.asList(
            Subjects.HIGHER_ALGEBRA,
            Subjects.LINEAR_ALGEBRA,
            Subjects.DIFF_GEOMETRY,
            Subjects.GENERAL_MATH);

    public MathSpeciality() {
        super(SPECIALITY);
    }

    @Override
    public List<Subjects> getCourse() {
        return mathCourse;
    }
}
