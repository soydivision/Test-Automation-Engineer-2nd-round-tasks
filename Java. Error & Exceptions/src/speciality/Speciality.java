package speciality;

import studentsubjects.*;

import java.util.List;

public abstract class Speciality {
    private String speciality;

    public Speciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public abstract List<StudentSubjects> getCourse();
}
