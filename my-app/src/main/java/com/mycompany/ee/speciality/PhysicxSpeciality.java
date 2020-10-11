package com.mycompany.ee.speciality;

import com.mycompany.ee.subjects.*;

import java.util.Arrays;
import java.util.List;

public class PhysicxSpeciality extends Speciality {
    public static final String SPECIALITY = "Physics";
    List<Subjects> physicsCourse = Arrays.asList(
            Subjects.ENERGY_AND_WORK,
            Subjects.GRAVITY,
            Subjects.NEWTON_LAWS,
            Subjects.KINEMATICS,
            Subjects.GENERAL_MATH
    );

    public PhysicxSpeciality() {
        super(SPECIALITY);
    }

    @Override
    public List<Subjects> getCourse() {
        return physicsCourse;
    }
}
