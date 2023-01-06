package lesson9.HW9;

public class CourseImpl implements Course {
    private String name;

    public CourseImpl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}