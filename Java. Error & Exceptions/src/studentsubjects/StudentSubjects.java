package studentsubjects;

public enum StudentSubjects {
    LAW,
    MATH,
    GENERAL_MATH,
    GENERAL_PHYSICX,
    HIGHER_ALGEBRA,
    GROUP_THEORY,
    INTERNATIONAL_LAW,
    GENERAL_CHEMISTRY,
    MATH_ANALYSIS,
    COMPUTER_SCIENCE,
    LINEAR_ALGEBRA,
    DIFF_GEOMETRY,
    TOPOLOGY,
    STATE_THEORY,
    LAW_HISTORY,
    GENERAL_ECONOMICS,
    ORGANIC_CHEMISTRY,
    NON_ORGANIC_CHEMISTRY,
    ANALYTICAL_CHEMISTRY,
    QUANTUM_CHEMISTRY;
    private String name;

    StudentSubjects(String name) {
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


