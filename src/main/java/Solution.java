import kotlin.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    //Just as described in the example
    private List<Pair<School, List<Student>>> solution = new ArrayList<>();
    private List<Student> matchedStudents = new ArrayList<>();

    private void clearLists() {
        solution.clear();
        matchedStudents.clear();
    }

    private void sortStudentsByScore(Problem PI) {
        PI.getSchoolPreferenceMap().forEach((iteratedSchool, iteratedStudents) -> {
            Collections.sort(iteratedStudents);
        });
    }

    // Simple 'matching' where the schools choose all available students, ordered by score
    public void matchSchoolsAndStudents(Problem PI) {
        //clearLists();
        sortStudentsByScore(PI);
        //PI.printSchoolsMap(); //debugging purposes
        PI.getSchoolPreferenceMap().forEach((iteratedSchool, iteratedStudents) -> {
            List<Student> studentsToAddInTheSolution = new ArrayList<>();
            iteratedStudents.forEach(iStudent -> {
                if(iteratedSchool.getCurrentNumberOfStudents() < iteratedSchool.getCapacity()) {
                    if(!matchedStudents.contains(iStudent)) {
                        studentsToAddInTheSolution.add(iStudent);
                        matchedStudents.add(iStudent);
                        iteratedSchool.setCurrentNumberOfStudents(iteratedSchool.getCurrentNumberOfStudents() + 1);
                    }
                }
            });
            Pair<School, List<Student>> pairToAdd = new Pair(iteratedSchool, studentsToAddInTheSolution);
            solution.add(pairToAdd);
        });
        PI.printMessageNewLine("========================================================");
        PI.printMessageNewLine("Solution: ");
        solution.forEach(schoolStudentPair -> {
            schoolStudentPair.getFirst().printToString();
            schoolStudentPair.getSecond().forEach(Student::printToString);
        });
    }
}
