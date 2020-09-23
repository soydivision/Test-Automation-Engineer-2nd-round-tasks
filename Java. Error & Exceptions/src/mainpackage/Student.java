package mainpackage;

import exceptions.NoSubjectsException;
import speciality.Speciality;
import subjects.Subjects;

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

    public Student(String name, String surName, Speciality speciality) {
        this.name = name;
        this.surName = surName;
        this.speciality = speciality;
        subjectScores = coreCourse();
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
        if (subjectScores.isEmpty()) throw new NoSubjectsException("This student has no subjects");
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
        for (Subjects studentSubject : speciality.getCourse()) {
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

    public boolean studentHasSubject(Enum<?> subject) {
        List<Subjects> subjectsList = speciality.getCourse();
        return subjectsList.contains(subject);
    }

    public int getSubjectMark(Enum<?> subject) {
        if (!studentHasSubject(subject)) {
            throw new NoSubjectsException();
        }
        int score = 0;
        for (SubjectScore thisSubjectScore : subjectScores) {
            if (thisSubjectScore.getSubject() == subject) {
                score = thisSubjectScore.getMark();
                break;
            }
        }
        return score;
    }

    @Override
    public String toString() {
        return name + " " + surName;
    }
}
