package com.mycompany.ee;

import com.mycompany.ee.mainpackage.Faculty;
import com.mycompany.ee.mainpackage.Group;
import com.mycompany.ee.mainpackage.Student;
import com.mycompany.ee.mainpackage.University;
import com.mycompany.ee.speciality.Specialities;
import com.mycompany.ee.subjects.Subjects;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Group math101_2020 = new Group("math101_2020", Arrays.asList(
                new Student("Васька", "Пупкин", Specialities.MATH, Subjects.MATH_COURSE_101),
                new Student("David", "Hilbert", Specialities.MATH, Subjects.MATH_COURSE_101),
                new Student("Pierre-Simon", "Laplace", Specialities.MATH, Subjects.MATH_COURSE_101),
                new Student("Renet", "Deqart", Specialities.MATH, Subjects.MATH_COURSE_101)
        ));
        Group physics101_2020 = new Group("physics101_2020", Arrays.asList(
                new Student("Enrico", "Fermi", Specialities.PHYSICX, Subjects.PHYSICS_COURSE_101),
                new Student("Niels", "Bohr", Specialities.PHYSICX, Subjects.PHYSICS_COURSE_101),
                new Student("Jean", "Joliot-Curie", Specialities.PHYSICX, Subjects.PHYSICS_COURSE_101),
                new Student("Albert", "Einstein", Specialities.PHYSICX, Subjects.PHYSICS_COURSE_101)
        ));
        Group astroboys101_2020 = new Group("astroboys101_2020", Arrays.asList(
                new Student("Reinhard", "Genzel", Specialities.ASTRONOMY, Subjects.ASTRONOMY_COURSE_101),
                new Student("Andrea", "Ghez", Specialities.ASTRONOMY, Subjects.ASTRONOMY_COURSE_101),
                new Student("Roger", "Penrose", Specialities.ASTRONOMY, Subjects.ASTRONOMY_COURSE_101),
                new Student("James", "Peebles", Specialities.ASTRONOMY, Subjects.ASTRONOMY_COURSE_101)
        ));
        Faculty mathAndPhysicsFaculty = new Faculty("Math and Physics", Arrays.asList(math101_2020, physics101_2020));
        Faculty astronomy = new Faculty("Astronomy", Arrays.asList(astroboys101_2020));
        University Stamford = new University("Stamford", Arrays.asList(mathAndPhysicsFaculty, astronomy));
        //      • Посчитать средний балл по всем предметам студента
        Student randomStudent = math101_2020.getRandomStudent();
        System.out.println("Students " + randomStudent.getName() + " average for all subjects is " + randomStudent.getAverageMarkForAllSubjects());
        //      • Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
        System.out.println("Average mark for " + math101_2020.getName() + " group, in " + Subjects.CALCULUS_ONE.getName() + " subject, is " + math101_2020.getAverageMarkForSubject(Subjects.CALCULUS_ONE));
        System.out.println("Average mark for " + astroboys101_2020.getName() + " group, in " + Subjects.CALCULUS_ONE.getName() + " subject, is " + astroboys101_2020.getAverageMarkForSubject(Subjects.CALCULUS_ONE));
        System.out.println("Average mark for " + physics101_2020.getName() + " group, in " + Subjects.CALCULUS_ONE.getName() + " subject, is " + physics101_2020.getAverageMarkForSubject(Subjects.CALCULUS_ONE));
        System.out.println("Average mark for " + mathAndPhysicsFaculty.getName() + " faculty in " + Subjects.CALCULUS_ONE.getName() + " is " + mathAndPhysicsFaculty.getAverageMarkForSubjectWithinFaculty(Subjects.CALCULUS_ONE));
        //      • Посчитать средний балл по предмету для всего университета
        System.out.println("Average mark for " + Stamford.getName() + " in " + Subjects.CALCULUS_ONE.getName() + " is " + Stamford.getAverageMarkForSubjectInUniversity(Subjects.CALCULUS_ONE));
    }
}
