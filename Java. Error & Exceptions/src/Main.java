
import subjects.*;
import speciality.*;
import mainpackage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Student Hu = new Student("Hu", "Tzingtao", new PhysicxSpeciality());
        Group math101_2020 = new Group("math101_2020", Arrays.asList(
                new Student("Васька", "Пупкин", new MathSpeciality()),
                new Student("David", "Hilbert", new MathSpeciality())
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
        Student randomStudentMath101 = math101_2020.getListOfStudents().get(ThreadLocalRandom.current().nextInt(0, math101_2020.getListOfStudents().size()));
        System.out.println(randomStudentMath101.getName() + " has average marks " + randomStudentMath101.getAverageMarkForAllSubjects());
    }
}
