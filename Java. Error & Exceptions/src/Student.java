import subjects.*;

public class Student {
    private String name;
    private String surName;

    public Student(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public String toString() {
        return "Student: " + name + " " + surName;
    }
}
