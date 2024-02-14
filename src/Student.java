import java.util.ArrayList;
import java.util.List;


public class Student {
    private String name;
    private int id;
    private List<String> courses;


    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

 
/*
    public Student(String name, int id, List<String> courses) {
        this.name = name;
        this.id = id;
        this.courses = courses;
    }
 */


    public int getId() {
        return id;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }
}