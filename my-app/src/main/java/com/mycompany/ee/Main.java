package com.mycompany.ee;

import com.mycompany.ee.mainpackage.*;
import com.mycompany.ee.speciality.FineArtsSpeciality;
import com.mycompany.ee.speciality.LawSpeciality;
import com.mycompany.ee.speciality.MathSpeciality;
import com.mycompany.ee.speciality.PhysicxSpeciality;
import com.mycompany.ee.subjects.Subjects;
import com.mycompany.ee.speciality.Specialities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Student ConstructionerTester = new Student("Lucky", "Strike", Specialities.MATH);
        Student ConstructionerTester1 = new Student("Lucky", "Strike", Specialities.MATH, Subjects.MATH_COURSE);
        Group math101_2020 = new Group("math101_2020", Arrays.asList(
                new Student("Васька", "Пупкин", new MathSpeciality()),
                new Student("David", "Hilbert", new MathSpeciality()),
                new Student("Pierre-Simon", "Laplace", new MathSpeciality())
        ));
    }
}
