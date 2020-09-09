import subjects.*;
import speciality.*;
import mainpackage.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Group mathG = new Group("Math101", Arrays.asList(
                new Student("Vaska", "Pupkin", new MathSpeciality())));
        Faculty FizMat = new Faculty("Fizmat", Arrays.asList(mathG));
        University Stanford = new University();
        System.out.println(mathG);
        System.out.println(FizMat);
        System.out.println(Stanford);
    }
}
