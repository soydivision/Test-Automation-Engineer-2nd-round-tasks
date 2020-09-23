import com.sun.javafx.scene.paint.GradientUtils;
import subjects.*;
import speciality.*;
import mainpackage.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student Hu = new Student("Hu", "Tzingtao", new PhysicxSpeciality());

        Group Math101_2020 = new Group("Math101_2020", Arrays.asList(
                new Student("Васька", "Пупкин", new MathSpeciality())));
        Group Physics101_2020 = new Group("Physics101_2020", Arrays.asList(
                new Student("Enrico", "Fermi", new PhysicxSpeciality()),
                new Student("Niels", "Bohr", new PhysicxSpeciality()),
                new Student("Jean", "Joliot-Curie", new PhysicxSpeciality()),
                new Student("Albert", "Einstein", new PhysicxSpeciality())
        ));
        Faculty PhysicsAndMath = new Faculty("Physics", Arrays.asList(Math101_2020, Physics101_2020));
        Group Lawyers101_2020 = new Group("Lawyers101_2020", Arrays.asList(
                new Student("Saul", "Goodman", new LawSpeciality())
        ));
        Faculty LawAndJustice = new Faculty("LawAndJustice", Arrays.asList(Lawyers101_2020));
        University Stanford = new University("Stanford", Arrays.asList(PhysicsAndMath, LawAndJustice));
        System.out.println(Stanford);
        Student randomStudent101 = Math101_2020.getListOfStudents().get(0);
        //Random if many
        System.out.println(randomStudent101.getName() + "  " + randomStudent101.getAverageScoreForAllSubjects());
    }
}
