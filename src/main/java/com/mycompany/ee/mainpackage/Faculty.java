package com.mycompany.ee.mainpackage;

import com.mycompany.ee.exceptions.*;

import java.util.List;

public class Faculty {
    private String name;
    private List<Group> GroupList;

    public Faculty() {
    }

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty(String name, List<Group> studentGroupList) {
        this.name = name;
        setGroupList(studentGroupList);
    }

    public String getName() {
        return name;
    }

    public void setName(String facultyName) {
        this.name = facultyName;
    }

    public List<Group> getStudentGroups() {
        return GroupList;
    }

    public void setGroupList(List<Group> GroupList) {
        if (GroupList.isEmpty()) throw new EmptyFacultyException("Faculty is empty");
        this.GroupList = GroupList;
    }

    public boolean facultyHasSubject(Enum<?> subject) {
        boolean facultyHasSubject = false;
        for (Group group : GroupList) {
            if (group.groupHasSubject(subject)) {
                facultyHasSubject = true;
            }
        }
        return facultyHasSubject;
    }

    public double getAverageMarkForSubjectWithinFaculty(Enum<?> subject) {
        double summOfMarks = 0;
        int groupHasSubject = 0;
        for (Group group : GroupList) {
            if (group.groupHasSubject(subject)) {
                summOfMarks += group.getAverageMarkForSubject(subject);
                groupHasSubject++;
            }
        }
        if (summOfMarks == 0 && groupHasSubject == 0)
            throw new NoSuchSubjectsException("No one at the faculty has this subject");
        return summOfMarks / groupHasSubject;
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "Faculty: " + name + ", Groups: " + GroupList + System.lineSeparator();
    }
}
