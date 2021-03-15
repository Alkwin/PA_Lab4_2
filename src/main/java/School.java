import org.jetbrains.annotations.NotNull;

public class School implements Comparable<School> {
    private final String name;
    private final Integer capacity;
    private Integer currentNumberOfStudents = 0;

    public Integer getCurrentNumberOfStudents() {
        return currentNumberOfStudents;
    }

    public void setCurrentNumberOfStudents(Integer currentNumberOfStudents) {
        this.currentNumberOfStudents = currentNumberOfStudents;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score = 0;

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    School(String newName, Integer newCapacity) {
        this.name = newName;
        this.capacity = newCapacity;
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
                "; " +
                "Capacity: " +
                this.capacity +
                '\n';
    }

    @Override
    public int compareTo(School o) { // To be able to make a TreeSet out of Schools
        return this.name.compareTo(o.name);
    }
}
