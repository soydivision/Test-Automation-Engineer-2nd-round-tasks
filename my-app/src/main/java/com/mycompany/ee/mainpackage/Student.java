package com.mycompany.ee.mainpackage;

import com.mycompany.ee.exceptions.NoSuchSubjectsException;
import com.mycompany.ee.speciality.Specialities;
//import com.mycompany.ee.speciality.Speciality;
import com.mycompany.ee.subjects.Subjects;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class Student {
    private String name;
    private String surName;
    private List<SubjectMark> subjectMarks;
    private Specialities specialities;
    private EnumSet<Subjects> course;

    public Student(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public Student(String name, String surName, Specialities specialities) {
        this.name = name;
        this.surName = surName;
        this.specialities = specialities;
    }

    public Student(String name, String surName, Specialities specialities, EnumSet<Subjects> mathCourse) {
        this.name = name;
        this.surName = surName;
        this.specialities = specialities;
        this.subjectMarks = coreCourseForSet(mathCourse);
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

    public List<SubjectMark> coreCourseForSet(EnumSet<Subjects> course) {
        List<SubjectMark> courseSetWithMarks = new ArrayList<>();
        for (Subjects studentSubject : course) {
            courseSetWithMarks.add(new SubjectMark(studentSubject, getRandomNumberInRange(4, 10)));
        }
        return courseSetWithMarks;
    }

    public List<Enum> getStudentSubjects() {
        List<Enum> subjectsList = new ArrayList<>();
        for (SubjectMark subjectMark : subjectMarks) {
            subjectsList.add(subjectMark.getSubject());
        }
        return subjectsList;
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
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
        List<Enum> subjectsList = getStudentSubjects();
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
