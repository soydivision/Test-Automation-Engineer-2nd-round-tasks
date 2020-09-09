import java.util.List;

public class Faculty {
    private String name;
    private List<Group> studentGroupList;

    public Faculty() {
    }

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty(String name, List<Group> studentGroupList) {
        this.name = name;
        setStudentGroupList(studentGroupList);
    }

    public String getFacultyName() {
        return name;
    }

    public void setFacultyName(String facultyName) {
        this.name = facultyName;
    }

    public List<Group> getStudentGroups() {
        return studentGroupList;
    }

    public void setStudentGroupList(List<Group> studentGroupList) {
        this.studentGroupList = studentGroupList;
    }

    public boolean facultyHasSubject(Enum<?> subject) {
        boolean facultyHasSubject = false;
        for (Group group : studentGroupList) {
            if (group.groupHasSubject(subject)) {
                facultyHasSubject = true;
            }
        }
        return facultyHasSubject;
    }

    public double getAverageMarkForSubjectWithinFaculty(Enum<?> subject) {
        double markSumm = 0;
        int groupHasSubject = 0;
        for (Group group : studentGroupList) {
            if (group.groupHasSubject(subject)) {
                markSumm += group.getAverageMarkForSubject(subject);
                groupHasSubject++;
            }
        }
        return markSumm / groupHasSubject;
    }

    @Override
    public String toString() {
        return "Faculty is " + name + ",Groups are" + studentGroupList;
    }
}
