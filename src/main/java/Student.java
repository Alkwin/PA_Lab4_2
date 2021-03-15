import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    private final String name;

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public String getName() {
        return name;
    }

    Student(String newName, int newScore) {
        this.name = newName;
        this.score = newScore;
    }

    //deprecated
    public void printToString() {
        System.out.print(
                this.toString()
        );
    }

    @Override
    public String toString() {
        return "Name: " +
                this.name +
                '\n' +
                "Score: " +
                this.score +
                '\n';
    }

    @Override
    public int compareTo(Student student) {
        return Integer.compare(student.getScore(), this.getScore());
    }
}
