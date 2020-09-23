
import subjects.*;
import speciality.*;
import mainpackage.*;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
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
        Group Lawyers101_2020 = new Group("Lawyers101_2020", Arrays.asList(
                new Student("Saul", "Goodman", new LawSpeciality()),
                new Student("Ромка", "Шишка", new LawSpeciality())
        ));
        Faculty LawAndJustice = new Faculty("LawAndJustice", Arrays.asList(Lawyers101_2020));
        Group fine_men101_2020 = new Group("fine_men101_2020", Arrays.asList(
                new Student("Mike", "Tison", new FineArtsSpeciality()),
                new Student("Denis", "Villeneuve", new FineArtsSpeciality())
        ));
        Faculty FineArts = new Faculty("FineArts", Arrays.asList(fine_men101_2020));
        University Stanford = new University("Stanford",
                Arrays.asList(PhysicsAndMath, LawAndJustice, FineArts));
        System.out.println(Stanford);
        Student randomMath101Student = math101_2020.getListOfStudents().get(ThreadLocalRandom.current().nextInt(0, math101_2020.getListOfStudents().size()));
        System.out.println(randomMath101Student.getName() + " has average marks " + randomMath101Student.getAverageMarkForAllSubjects());
        System.out.println("Math gr has kung fu " + math101_2020.groupHasSubject(Subjects.KUNG_FU));
        Subjects subjectToCheck = Subjects.KUNG_FU;
        System.out.print("For " + math101_2020.getName() + "group " + subjectToCheck.getName() + " subject,  average mark is: ");
        System.out.print(math101_2020.getAverageMarkForSubject(Subjects.GENERAL_MATH));
        System.out.println("Hu has kung fu " + Hu.studentHasSubject(Subjects.KUNG_FU));
        System.out.println(Arrays.toString(Hu.getSubjectMarks().toArray()));
    }
}
