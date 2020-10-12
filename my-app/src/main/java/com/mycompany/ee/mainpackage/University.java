package com.mycompany.ee.mainpackage;

import com.mycompany.ee.exceptions.*;

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

    public void setFaculties(List<Faculty> faculties) throws EmptyUniversityException {
        if (faculties.isEmpty()) throw new EmptyUniversityException("University has no faculties");
        this.faculties = faculties;
    }

    public double getAverageMarkForSubjectInUniversity(Enum<?> subject) {
        double markSumm = 0;
        int facultyHasSubject = 0;
        for (Faculty faculty : faculties) {
            if (faculty.facultyHasSubject(subject)) {
//                System.out.println(faculty.getName() + " has " + subject.name());
//                System.out.println("markSumm before : " + markSumm);
//                System.out.println("faculty.getAverageMarkForSubjectWithinFaculty(subject) in " + faculty.getName() + " is " + faculty.getAverageMarkForSubjectWithinFaculty(subject));
                markSumm = markSumm + faculty.getAverageMarkForSubjectWithinFaculty(subject);
//                System.out.println("markSumm after : " + markSumm);
                facultyHasSubject++;
//                System.out.println("facultyHasSubject: " + facultyHasSubject);
            }
        }
        if (markSumm == 0 && facultyHasSubject == 0) throw new NoSuchSubjectsException("Studens has no such subject");
        return markSumm / facultyHasSubject;
    }

    @Override
    public String toString() {
        return "University: " + name + " ,faculties:" + faculties + System.lineSeparator();
    }
}
