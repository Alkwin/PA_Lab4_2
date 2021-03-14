public class Student {
    private final String name;
    private int score;
    public String getName() {
        return name;
    }

    Student(String newName, int newScore) {
        this.name = newName;
        this.score = newScore;
    }

    public void printInfo() {
        System.out.print(
                "Name: " +
                        this.name +
                        "; " +
                        "Score: " +
                        this.score +
                        '\n'
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
}
