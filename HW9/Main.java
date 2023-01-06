package lesson9.HW9;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Course course1 = new CourseImpl("Математика");
        Course course2 = new CourseImpl("Психология");
        Course course3 = new CourseImpl("Робототехника");
        Course course4 = new CourseImpl("Физика");
        Course course5 = new CourseImpl("Биология");

        List<Student> students = Arrays.asList(
                new StudentImpl("Самуилова", Arrays.asList(course1, course3,course4)),
                new StudentImpl("Петров", Arrays.asList(course1,course2, course3,course4)),
                new StudentImpl("Валецкий", Arrays.asList(course1, course2)),
                new StudentImpl("Крымская", Arrays.asList(course4)),
                new StudentImpl("Шабан", Arrays.asList(course1)),
                new StudentImpl("Хотун", Arrays.asList(course5)),
                new StudentImpl("Боридько", Arrays.asList( course3))
        );

        System.out.println(" Студенты посещают курсы:"+ getUniqueCourses(students));
        System.out.println(" Самые любознательные студенты:"+ getInquisitiveStudent(students));

        System.out.println(" Математику посещают:" +getStudentsByCourses(students, course1));
        System.out.println(" Психологию посещают:" +getStudentsByCourses(students, course2));
        System.out.println(" Робототехнику посещают:" +getStudentsByCourses(students, course3));
        System.out.println(" Физику посещают:" + getStudentsByCourses(students, course4));
        System.out.println(" Биологию посещают:" + getStudentsByCourses(students, course5));
    }

    public static List<Course> getUniqueCourses(List<Student> students) {
        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .map(Student::getAllCourses)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Student> getInquisitiveStudent(List<Student> students) {
        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .sorted((o1, o2) -> {
                    List<Course> c1 = o1.getAllCourses();
                    List<Course> c2 = o2.getAllCourses();
                    return Integer.compare(
                            c2 == null ? 0 : c2.size(),
                            c1 == null ? 0 : c1.size()
                    );
                })
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentsByCourses(List<Student> students, Course course) {
        if (course == null) {
            return new ArrayList<>();
        }

        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .filter(student -> {
                    List<Course> courses = student.getAllCourses();
                    courses = courses == null ? Collections.emptyList() : courses;
                    return courses.contains(course);
                })
                .collect(Collectors.toList());
    }
}