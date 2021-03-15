import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {

    private int numberOfStudents = 10;
    private int numberOfSchools = 10;

    public int getNumberOfSchools() {
        return numberOfSchools;
    }

    public void setNumberOfSchools(int numberOfSchools) {
        this.numberOfSchools = numberOfSchools;
    }

    private Student[] students = new Student[0];
    private School[] schools = new School[0];
    private List<Student> studentList = new LinkedList<>();
    private Set<School> schoolTreeSet = new TreeSet<>();
    private Map<Student, List<School>> studentPreferenceMap = new HashMap<>();
    private Map<School, List<Student>> schoolPreferenceMap = new TreeMap<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Set<School> getSchoolTreeSet() {
        return schoolTreeSet;
    }

    public void setSchoolTreeSet(Set<School> schoolTreeSet) {
        this.schoolTreeSet = schoolTreeSet;
    }

    public Map<Student, List<School>> getStudentPreferenceMap() {
        return studentPreferenceMap;
    }

    public void setStudentPreferenceMap(Map<Student, List<School>> studentPreferenceMap) {
        this.studentPreferenceMap = studentPreferenceMap;
    }

    public Map<School, List<Student>> getSchoolPreferenceMap() {
        return schoolPreferenceMap;
    }

    public void setSchoolPreferenceMap(Map<School, List<Student>> schoolPreferenceMap) {
        this.schoolPreferenceMap = schoolPreferenceMap;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public School[] getSchools() {
        return schools;
    }

    public void setSchools(School[] schools) {
        this.schools = schools;
    }

    void printSchoolsMap() {
        schoolTreeSet.forEach(school -> {
            printMessageNewLine("School information:");
            printMessageNewLine(school.toString());
            printMessageNewLine("School's choices:");
            schoolPreferenceMap.get(school).forEach(Student::printToString);
            printMessageNewLine("");
        });
    }

    void printStudentsMap() {
        studentList.forEach(student -> {
            printMessageNewLine("Student information:");
            printMessageNewLine(student.toString());
            printMessageNewLine("Student's choices:");
            studentPreferenceMap.get(student).forEach(School::printToString);
            printMessageNewLine("");
        });
    }


    void printSchools(Set<School> schools) {
        for (School school : schools) {
            school.printToString();
        }
    }

    void printStudents(List<Student> students) {
        for (Student student : students) {
            student.printToString();
        }
    }

    void printMessageNewLine(String message) {
        System.out.println(message);
    }

    // Return a list of students that have all of the givenSchools in their preferences
    List<Student> getFitStudents(List<School> givenSchools) {
        return studentList.stream()
                .filter(student -> studentPreferenceMap
                        .get(student)
                        .containsAll(givenSchools)
                )
                .collect(Collectors.toList());
    }

    // Return a list of school that have a given student as their top choice
    List<School> getSchoolsWithTopChoice(Student student) {
        return schoolTreeSet.stream()
                .filter(school -> schoolPreferenceMap
                        .get(school)
                        .get(0)
                        .getName()
                        .equals(student.getName())
                )
                .collect(Collectors.toList());
    }

    public String getRandomStudentName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public int getRandomStudentScore() {
        Faker faker = new Faker();
        return faker.number().numberBetween(1, 10);
    }

    public int getRandomCapacity() {
        Faker faker = new Faker();
        return faker.number().numberBetween(1, 10);
    }

    public String getRandomSchoolName() {
        Faker faker = new Faker();
        return faker.university().name();
    }

    public List<School> getRandomSchoolsList() {
        Faker faker = new Faker();
        List<School> newSchoolsList = new ArrayList<School>();
        int numberOfPreferences = faker.number().numberBetween(1, 10);
        for(int i = 0 ; i < numberOfPreferences; i ++) {
            var schoolToAdd = schools[faker.number().numberBetween(1, schools.length)];
            if(!newSchoolsList.contains(schoolToAdd)) {
                newSchoolsList.add(schoolToAdd);
            }
        }
        return newSchoolsList;
    }

    public List<Student> getRandomStudentsList() {
        Faker faker = new Faker();
        List<Student> newStudentsList = new ArrayList<Student>();
        int numberOfPreferences = faker.number().numberBetween(1, 10);
        for(int i = 0 ; i < numberOfPreferences; i ++) {
            var studentToAdd = students[faker.number().numberBetween(1, students.length)];
            if(!newStudentsList.contains(studentToAdd)) {
                newStudentsList.add(studentToAdd);
            }
        }
        return newStudentsList;
    }
}
