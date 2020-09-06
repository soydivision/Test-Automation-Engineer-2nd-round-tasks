package speciality;

import studentsubjects.StudentSubjects;

import java.util.Arrays;
import java.util.List;

public class MathSpeciality extends Speciality {
    public static final String SPECIALITY = "math";
    private List<StudentSubjects> mathCourse = Arrays.asList(StudentSubjects.HIGHER_ALGEBRA,
            StudentSubjects.LINEAR_ALGEBRA, StudentSubjects.DIFF_GEOMETRY, StudentSubjects.GENERAL_MATH);

    public MathSpeciality() {
        super(SPECIALITY);
    }

    @Override
    public List<StudentSubjects> getCourse() {
        return mathCourse;
    }
}
