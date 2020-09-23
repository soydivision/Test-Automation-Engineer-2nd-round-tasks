package mainpackage;

import exceptions.NoSuchSubjectsException;
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
        if (subjectMarks.isEmpty()) throw new NoSuchSubjectsException("This student has no subjects");
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
            throw new NoSuchSubjectsException("Student " + name + " has no such" + subject.name() + " subject ");
        }
        int mark = 0;
        for (SubjectMark subjectMark : subjectMarks) {
            if (subjectMark.getSubject() == subject) {
                mark = subjectMark.getMark();
            }
        }
        return mark;
    }

    @Override
    public String toString() {
        return name + " " + surName;
    }
}
