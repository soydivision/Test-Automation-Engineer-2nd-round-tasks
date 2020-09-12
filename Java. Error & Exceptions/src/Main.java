import subjects.*;
import speciality.*;
import mainpackage.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student Hu = new Student("Hu", "Tzingtao", new PhysicxSpeciality());
        System.out.println(Hu);
        Group Math101_2020 = new Group("Math101", Arrays.asList(
                new Student("Vaska", "Pupkin", new MathSpeciality())));
        Faculty FizMat = new Faculty("Fizmat", Arrays.asList(Math101_2020));
        Group Lawyers101_2020 = new Group("Lawyers101_2020", Arrays.asList(
                new Student("Saul", "Goodman", new LawSpeciality())
        ));
        Faculty LawAndJustice = new Faculty("LawAndJustice", Arrays.asList(Lawyers101_2020));
        University Stanford = new University("Stanford", Arrays.asList(FizMat, LawAndJustice));
        System.out.println(Stanford);
        Faculty Physics = new Faculty("Physics", Arrays.asList());
        //Enrico Fermi ,Niels Henrik David Bohr, Jean Frédéric Joliot-Curie
        Student randomStudent101 = Math101_2020.getListOfStudents().get(0);
        //Random if many
        System.out.println(randomStudent101.getName() + "  " + randomStudent101.getAverageScoreForAllSubjects());
    }
}
