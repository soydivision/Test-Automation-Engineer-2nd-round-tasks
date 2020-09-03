package speciality;

abstract class Speciality {
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
    // public abstract List<> getCourse
}