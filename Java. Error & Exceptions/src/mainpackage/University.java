package mainpackage;

import java.util.List;

public class University {
    private String name;
    private List<Faculty> faculties;

    public University() {
    }

    public University(String name, List<Faculty> faculties) {
        this.name = name;
        setFaculties(faculties);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return "University: " + name + " ,faculties:" + faculties + System.lineSeparator();
    }
}
