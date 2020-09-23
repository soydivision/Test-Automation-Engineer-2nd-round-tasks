package mainpackage;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import exceptions.NoSubjectsException;
import speciality.Speciality;
import subjects.Subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Student {
    private String name;
    private String surName;
    private List<SubjectMark> subjectMarks;
    private Speciality speciality;

    public Student(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public Student(String name, String surName, Speciality speciality) {
        this.name = name;
        this.surName = surName;
        this.speciality = speciality;
        subjectMarks = coreCourse();
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public List<SubjectMark> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(List<SubjectMark> subjectMarks) {
        if (subjectMarks.isEmpty()) throw new NoSubjectsException("This student has no subjects");
        this.subjectMarks = subjectMarks;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<SubjectMark> coreCourse() {
        List<SubjectMark> subjectMarkList = new ArrayList<>();
        for (Subjects studentSubject : speciality.getCourse()) {
            subjectMarkList.add(new SubjectMark(studentSubject, ThreadLocalRandom.current().nextInt(0, 5)));
        }
        return subjectMarkList;
    }

    public double getAverageMarkForAllSubjects() {
        int sumOfMarks = 0;
        int numberOfMarks = subjectMarks.size();
        System.out.println("numberOfMarks " + numberOfMarks);
        for (SubjectMark subjectMark : subjectMarks) {
            sumOfMarks += subjectMark.getMark();

        }
        return (double) sumOfMarks / numberOfMarks;
    }

    public boolean studentHasSubject(Enum<?> subject) {
        List<Subjects> subjectsList = speciality.getCourse();
        return subjectsList.contains(subject);
    }

    public int getSubjectMark(Enum<?> subject) {
        if (!studentHasSubject(subject)) {
            throw new NoSubjectsException();
        }
        int mark = 0;
        for (SubjectMark thisSubjectMark : subjectMarks) {
            if (thisSubjectMark.getSubject() == subject) {
                mark = thisSubjectMark.getMark();
                break;
            }
        }
        return mark;
    }

    @Override
    public String toString() {
        return name + " " + surName;
    }
}
