package speciality;

import studentsubjects.*;

import javax.security.auth.Subject;
import java.util.Arrays;
import java.util.List;

public class PhysicxSpeciality extends Speciality {
    public static final String SPECIALITY = "Physics";
    List<StudentSubjects> physicsCourse = Arrays.asList(
            StudentSubjects.ENERGY_AND_WORK,
            StudentSubjects.GRAVITY,
            StudentSubjects.NEWTON_LAWS,
            StudentSubjects.KINEMATICS
    )

    public PhysicxSpeciality() {
        super(SPECIALITY);
    }

    @Override
    public List<StudentSubjects> getCourse() {
        return null;
    }
}
