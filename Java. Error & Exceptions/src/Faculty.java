import java.util.List;

public class Faculty {
    private String name;
    private List<StudentGroup> studentGroupList;

    public Faculty() {
    }

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty(String name, List<StudentGroup> studentGroupList) {
        this.name = name;
        setStudentGroups();
    }

    public String getFacultyName() {
        return name;
    }

    public void setFacultyName(String facultyName) {
        this.name = facultyName;
    }

    public List<StudentGroup> getStudentGroups() {
        return studentGroupList;
    }

    public void setStudentGroupList(List<StudentGroup> studentGroupList) {
        this.studentGroupList = studentGroupList;
    }

    public boolean checkSubjectInFaculty() {
        boolean facultyHasSubject = false;
        for (StudentGroup group:studentGroupList){
            if (group.)
        }
    }

    public void setStudentGroups() {
    }
}
