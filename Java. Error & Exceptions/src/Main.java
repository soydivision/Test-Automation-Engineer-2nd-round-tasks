import mainpackage.Faculty;
import mainpackage.Group;
import mainpackage.Student;
import mainpackage.University;
import speciality.*;
import subjects.Subjects;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
//
        Student Hu = new Student("Hu", "Tzingtao", new MathSpeciality());
        Group math101_2020 = new Group("math101_2020", Arrays.asList(
                new Student("Васька", "Пупкин", new MathSpeciality()),
                new Student("David", "Hilbert", new MathSpeciality()),
                new Student("Pierre-Simon", "Laplace", new MathSpeciality()),
                Hu
        ));
        Group physics101_2020 = new Group("physics101_2020", Arrays.asList(
                new Student("Enrico", "Fermi", new PhysicxSpeciality()),
                new Student("Niels", "Bohr", new PhysicxSpeciality()),
                new Student("Jean", "Joliot-Curie", new PhysicxSpeciality()),
                new Student("Albert", "Einstein", new PhysicxSpeciality())
        ));
        Faculty PhysicsAndMath = new Faculty("Physics", Arrays.asList(math101_2020, physics101_2020));
//
        Group lawyers101_2020 = new Group("lawyers101_2020", Arrays.asList(
                new Student("Saul", "Goodman", new LawSpeciality()),
                new Student("Ромка", "Шишка", new LawSpeciality())
        ));
        Group detectives101_2020 = new Group("dete", Arrays.asList(
                new Student(" Rustin", "Cohle", new LawSpeciality()),
                new Student("Martin", "Hart", new LawSpeciality())
        ));
        Faculty LawAndJustice = new Faculty("Law And Justice", Arrays.asList(lawyers101_2020, detectives101_2020));
        Group fine_men101_2020 = new Group("fine_men101_2020", Arrays.asList(
                new Student("Mike", "Tison", new FineArtsSpeciality()),
                new Student("Denis", "Villeneuve", new FineArtsSpeciality())
        ));
        Faculty FineArts = new Faculty("Fine Arts", Arrays.asList(fine_men101_2020));
        University Stanford = new University("Stanford",
                Arrays.asList(PhysicsAndMath, LawAndJustice, FineArts));
//        Посчитать средний балл по всем предметам студента
        Student randomMath101Student = math101_2020.getListOfStudents().get(ThreadLocalRandom.current().nextInt(0, math101_2020.getListOfStudents().size()));
        System.out.println(randomMath101Student.getName() + " has average marks " + randomMath101Student.getAverageMarkForAllSubjects());
//        Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
        System.out.println("Average mark for " + Subjects.INTERNATIONAL_LAW.getName() + " is " + lawyers101_2020.getAverageMarkForSubject(Subjects.INTERNATIONAL_LAW) + " for " + lawyers101_2020.getName() + " group");
        System.out.println(LawAndJustice.getName() + " faculty has average " + LawAndJustice.getAverageMarkForSubjectWithinFaculty(Subjects.INTERNATIONAL_LAW) + " on " + Subjects.INTERNATIONAL_LAW.getName());
//        Посчитать средний балл по предмету для всего университета
        System.out.println("Average mark for " + Stanford.getName() + " university is " + Stanford.getAverageMarkForSubjectInUniversity(Subjects.GENERAL_MATH));
    }
}
