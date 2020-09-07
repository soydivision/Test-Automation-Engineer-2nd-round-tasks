import java.util.List;

public class StudentGroup {
    private String name;
    private List<Student> listOfStudents;

    public StudentGroup() {
    }

    public StudentGroup(String name) {
        this.name = name;
    }

    public StudentGroup(String name, List<Student> listOfStudents) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public boolean groupHasSubject(Enum<?> subject) {
        boolean groupHasSubject = false;
        for (Student student : listOfStudents) {
            if (student.studentHasSubject(subject)) groupHasSubject = true;
        }
        return groupHasSubject;
    }
}
