import java.util.*;
import java.util.stream.IntStream;

public class Compulsory {
    public void executeCompulsory() {
        int numberOfStudents = 3; //actually 3+1
        var students = IntStream.rangeClosed(0, numberOfStudents)
                .mapToObj(studentNumber -> new Student("S" + (numberOfStudents-studentNumber), 0)) //(numberOfStudents-studentNumber)
                .toArray(Student[]::new);                                                       // To check if the sorting method (*) works

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(schoolNumber -> new School(
                        "H" + schoolNumber,
                        chooseSchoolCapacity(schoolNumber)
                ))
                .toArray(School[]::new);

        List<Student> studentList = new LinkedList<>(Arrays.asList(students));

        Collections.sort(studentList, //*
                (student1, student2) -> student1
                        .getName()
                        .compareToIgnoreCase(
                                student2.getName()
                        )
        );

        Set<School> schoolTreeSet = new TreeSet<>(Arrays.asList(schools));

        //printStudents(studentList);
        //printSchools(schoolTreeSet);

        Map<Student, List<School>> studentPreferenceMap = new HashMap<>();
        studentList.forEach(student -> {
            studentPreferenceMap.put(
                    student,
                    getSchoolsListForStudent(student, schoolTreeSet)
            );
        });

        Map<School, List<Student>> schoolPreferenceMap = new TreeMap<>();
        schoolTreeSet.forEach(school -> {
            schoolPreferenceMap.put(
                    school,
                    getStudentsListForSchool(school, studentList)
            );
        });

        printStudentsMap(studentList, studentPreferenceMap);

        printSchoolsMap(schoolTreeSet, schoolPreferenceMap);
    }

    private void printSchoolsMap(Set<School> schoolTreeSet, Map<School, List<Student>> schoolPreferenceMap) {
        schoolTreeSet.forEach(school -> {
            printMessageNewLine("School information:");
            school.printToString();
            printMessageNewLine("School's choices:");
            schoolPreferenceMap.get(school).forEach(Student::printToString);
            printMessageNewLine("");
        });
    }

    private void printStudentsMap(List<Student> studentList, Map<Student, List<School>> studentPreferenceMap) {
        studentList.forEach(student -> {
            printMessageNewLine("Student information:");
            student.printToString();
            printMessageNewLine("Student's choices:");
            studentPreferenceMap.get(student).forEach(School::printToString);
            printMessageNewLine("");
        });
    }

    /**
     * Cleanest method I could find to hardcore values: switches
     */
    private List<Student> getStudentsListForSchool(School school, List<Student> studentList) {
        List<Student> studentsList = new ArrayList<>(studentList);
        return switch(school.getName()) {
            case "H0" -> Arrays.asList(
                    studentsList.get(3),
                    studentsList.get(0),
                    studentsList.get(1),
                    studentsList.get(2)
            );
            case "H1" -> Arrays.asList(
                    studentsList.get(0),
                    studentsList.get(2),
                    studentsList.get(1)
            );
            case "H2" -> Arrays.asList(
                    studentsList.get(0),
                    studentsList.get(1),
                    studentsList.get(3)
            );
            default -> null;
        };
    }

    private List<School> getSchoolsListForStudent(Student student, Set<School> schoolTreeSet) {
        List<School> schoolList = new ArrayList<>(schoolTreeSet);
        return switch(student.getName()) {
            case "S0", "S1" -> Arrays.asList(
                    schoolList.get(0),
                    schoolList.get(1),
                    schoolList.get(2)
            );
            case "S2" -> Arrays.asList(
                    schoolList.get(0),
                    schoolList.get(1)
            );
            case "S3" -> Arrays.asList(
                    schoolList.get(0),
                    schoolList.get(2)
            );
            default -> null;
        };
    }

    private int chooseSchoolCapacity(Integer s) {
        // School capacities, in order: 1, 2, 2
        return switch (s) {
            case 0 -> 1;
            case 1, 2 -> 2;
            default -> -1;
        };

    }

    private void printSchools(Set<School> schools) {
        for (School school : schools) {
            school.printToString();
        }
    }

    private void printStudents(List<Student> students) {
        for (Student student : students) {
            student.printToString();
        }
    }

    private void printMessageNewLine(String message) {
        System.out.println(message);
    }

}