import java.util.*;
import java.util.stream.IntStream;

public class Optional {
    public void executeOptional() {
        Problem PI = new Problem(); // PI = Problem Instance; shortened for improved readability
        PI.setStudents(IntStream.rangeClosed(0, PI.getNumberOfStudents())
                .mapToObj(studentNumber -> new Student(
                        PI.getRandomStudentName(),
                        PI.getRandomStudentScore())
                )
                .toArray(Student[]::new));

        PI.setSchools(IntStream.rangeClosed(0, PI.getNumberOfSchools())
                .mapToObj(schoolNumber -> new School(
                        PI.getRandomSchoolName(),
                        PI.getRandomCapacity()
                ))
                .toArray(School[]::new));

        PI.setStudentList(
                new LinkedList<>(
                        Arrays.asList(
                                PI.getStudents()
                        )
                )
        );

        PI.setSchoolTreeSet(
                new TreeSet<>(
                        Arrays.asList(
                                PI.getSchools()
                        )
                )
        );

        Collections.sort(PI.getStudentList(),
                (student1, student2) -> student1
                        .getName()
                        .compareToIgnoreCase(
                                student2.getName()
                        )
        );

        Map<Student, List<School>> newStudentPreferenceMap = new HashMap<>();
        PI.getStudentList().forEach(student -> {
            newStudentPreferenceMap.put(
                    student,
                    PI.getRandomSchoolsList()
            );
        });
        PI.setStudentPreferenceMap(newStudentPreferenceMap);

        Map<School, List<Student>> newSchoolPreferenceMap = new TreeMap<>();
        PI.getSchoolTreeSet().forEach(school -> {
            newSchoolPreferenceMap.put(
                    school,
                    PI.getRandomStudentsList()
            );
        });
        PI.setSchoolPreferenceMap(newSchoolPreferenceMap);

        PI.printStudentsMap();
        PI.printSchoolsMap();

        PI.printMessageNewLine("---------------------------------------------------------------------------");

        var fitStudents = PI.getFitStudents(new ArrayList<>(PI.getSchoolTreeSet()));

        PI.printMessageNewLine("Students that would go to any school: ");
        fitStudents.forEach( student -> {
            PI.printMessageNewLine(student.toString());
        });

        var schoolsWithTopChoice = PI.getSchoolsWithTopChoice(
                PI.getStudentList().get(2)
        );
        PI.printMessageNewLine("Schools that have the student named " + PI.getStudents()[2].getName() +" as their top choice: ");
        schoolsWithTopChoice.forEach(school -> {
            PI.printMessageNewLine(school.toString());
        });

    }
}
