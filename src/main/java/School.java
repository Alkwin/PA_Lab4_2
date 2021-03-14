import org.jetbrains.annotations.NotNull;

public class School implements Comparable<School> {
    private final String name;
    private final Integer capacity;

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

    public void printInfo() {
        System.out.print(
                "Name: " +
                this.name +
                        "; " +
                        "Capacity: " +
                        this.capacity +
                        '\n'
        );

    }


    @Override
    public int compareTo(@NotNull School o) { // To be able to make a TreeSet out of Schools
        return this.name.compareTo(o.name);
    }
}
