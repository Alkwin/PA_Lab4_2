public class Student {
    private final String name;

    public String getName() {
        return name;
    }

    Student(String newName) {
        this.name = newName;
    }

    public void printInfo() {
        System.out.print(
                "Name: " +
                        this.name +
                        '\n'
        );
    }

}
