package com.mycompany.ee.subjects;

import java.util.EnumSet;

public enum Subjects {
    LAW("LAW"),
    MATH("MATH"),
    GENERAL_MATH("GENERAL_MATH"),
    GENERAL_PHYSICS("GENERAL_PHYSICS"),
    HIGHER_ALGEBRA("HIGHER_ALGEBRA"),
    GROUP_THEORY("GROUP_THEORY"),
    INTERNATIONAL_LAW("INTERNATIONAL_LAW"),
    GENERAL_CHEMISTRY("GENERAL_CHEMISTRY"),
    MATH_ANALYSIS("MATH_ANALYSIS"),
    COMPUTER_SCIENCE("COMPUTER_SCIENCE"),
    LINEAR_ALGEBRA("LINEAR_ALGEBRA"),
    DIFF_GEOMETRY("DIFF_GEOMETRY"),
    TOPOLOGY("TOPOLOGY"),
    STATE_THEORY("STATE_THEORY"),
    LAW_HISTORY("LAW_HISTORY"),
    GENERAL_ECONOMICS("GENERAL_ECONOMICS"),
    ORGANIC_CHEMISTRY("ORGANIC_CHEMISTRY"),
    NON_ORGANIC_CHEMISTRY("NON_ORGANIC_CHEMISTRY"),
    ANALYTICAL_CHEMISTRY("ANALYTICAL_CHEMISTRY"),
    QUANTUM_CHEMISTRY("QUANTUM_CHEMISTRY"),
    KINEMATICS("KINEMATICS"),
    FORCES("FORCES"),
    GRAVITY("GRAVITY"),
    NEWTON_LAWS("NEWTON_LAWS"),
    ENERGY_AND_WORK("ENERGY_AND_WORK"),
    OPTICS("OPTICS"),
    FLUID_DYNAMICS("FLUID_DYNAMICS"),
    KUNG_FU("KUNG_FU"),
    CPLUSPLUS("C++"),
    CALCULUS_ONE("CALCULUS-1"),
    CALCULUS_TWO("CALCULUS-2");
    private String name;

    public static final EnumSet<Subjects> MATH_COURSE_101 = EnumSet.of(
            Subjects.DIFF_GEOMETRY,
            Subjects.GENERAL_MATH,
            Subjects.CALCULUS_ONE
    );
    public static final EnumSet<Subjects> MATH_COURSE_102 = EnumSet.of(
            Subjects.DIFF_GEOMETRY,
            Subjects.GENERAL_MATH,
            Subjects.CALCULUS_TWO
    );

    public static final EnumSet<Subjects> PHYSICS_COURSE_101 = EnumSet.of(
            Subjects.GENERAL_PHYSICS,
            Subjects.KINEMATICS,
            Subjects.CALCULUS_ONE
    );

    public static final EnumSet<Subjects> LAW_COURSE_101 = EnumSet.of(
            Subjects.LAW_HISTORY,
            Subjects.INTERNATIONAL_LAW,
            Subjects.STATE_THEORY
    );

    public static final EnumSet<Subjects> FINE_ARTS_COURSE_101 = EnumSet.of(
            Subjects.LAW_HISTORY,
            Subjects.INTERNATIONAL_LAW,
            Subjects.STATE_THEORY
    );

    public static final EnumSet<Subjects> ASTRONOMY_COURSE_101 = EnumSet.of(
            Subjects.CALCULUS_ONE,
            Subjects.INTERNATIONAL_LAW,
            Subjects.STATE_THEORY
    );

    Subjects(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}


