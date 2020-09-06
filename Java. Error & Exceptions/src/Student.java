import speciality.*;
import studentsubjects.*;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String surName;
    private List<SubjectScore> subjectScores;
    private Speciality speciality;

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

    public List<SubjectScore> getSubjectScores() {
        return subjectScores;
    }

    public void setSubjectScores(List<SubjectScore> subjectScores) {
        //Exception
        this.subjectScores = subjectScores;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<SubjectScore> coreCourse() {
        List<SubjectScore> subjectScoresList = new ArrayList<>();
        for (StudentSubjects studentSubject : speciality.getCourse()) {
            subjectScoresList.add(new SubjectScore(studentSubject, 7));
        }
        return subjectScoresList;
    }

    public double getAverageScoreForAllSubjects() {
        int sumOfMarks = 0;
        int numberOfMarks = subjectScores.size();
        for (SubjectScore subjectScore : subjectScores) {
            sumOfMarks += subjectScore.getMark();
        }
        return (double) sumOfMarks / numberOfMarks;
    }

    public boolean isSubjectPresent(Enum<?> subject) {
    }

    public int getSubjectMark(Enum<?> subject) {
    }

    @Override
    public String toString() {
        return "Student: " + name + " " + surName;
    }
}
