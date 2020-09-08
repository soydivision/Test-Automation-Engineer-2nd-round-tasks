import java.util.List;

public class Group {
    private String name;
    private List<Student> listOfStudents;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, List<Student> listOfStudents) {
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
