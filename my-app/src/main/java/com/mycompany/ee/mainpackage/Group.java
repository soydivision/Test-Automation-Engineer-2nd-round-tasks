package com.mycompany.ee.mainpackage;

import com.mycompany.ee.subjects.*;

import java.util.List;
import java.util.Random;

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
        setListOfStudents(listOfStudents);
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

    public Student getRandomStudent() {
        return listOfStudents.get(getRandomNumberInRange(0, listOfStudents.size()-1));
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
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

    public double getAverageMarkForSubject(Enum<?> subject) {
        double markSumm = 0;
        int markNumber = 0;
        List<Student> listOfStudents = getListOfStudents();
        for (Student student : listOfStudents) {
            if (student.studentHasSubject(subject)) {
                markSumm = markSumm + student.getSubjectMark(subject);
                markNumber++;
            }
        }
        return markSumm / markNumber;
    }

    @Override
    public String toString() {
        return " Group: " + name + System.lineSeparator() + " ,students: " + listOfStudents + System.lineSeparator();
    }
}
