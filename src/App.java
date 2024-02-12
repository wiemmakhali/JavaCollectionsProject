import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        Map<Integer, Student> studentMap = new HashMap<>();

        Student student1 = new Student("Jason", 2001);
        student1.addCourse("Math");
        student1.addCourse("English");
        student1.addCourse("History");
        studentMap.put(student1.getId(), student1);

        Student student2 = new Student("Ava", 2002);
        student2.addCourse("Science");
        student2.addCourse("English");
        student2.addCourse("Art");
        studentMap.put(student2.getId(), student2);

        Student student3 = new Student("Mike", 2003);
        student3.addCourse("Math");
        student1.addCourse("History");
        student3.addCourse("Geography");
        studentMap.put(student3.getId(), student3);

        for (Student student : studentMap.values()) {
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Courses: " + student.getCourses());
        }

    
        List<String> allCourses = new ArrayList<>();
        for (Student student : studentMap.values()) {
            allCourses.addAll(student.getCourses());
        }
/* 
  
        Set<String> uniqueCourses = new HashSet<>(allCourses);


        for (String course : uniqueCourses) {
            System.out.println("Course: " + course);
        }

        Map<String, List<Student>> courseMap = new HashMap<>();
        for (Student student : studentMap.values()) {
            for (String course : student.getCourses()) {
                if (courseMap.containsKey(course)) {
                    courseMap.get(course).add(student);
                } else {
                    List<Student> students = new ArrayList<>();
                    students.add(student);
                    courseMap.put(course, students);
                }
            }
        }


        for (Map.Entry<String, List<Student>> entry : courseMap.entrySet()) {
            System.out.println("Course: " + entry.getKey());
            System.out.println("Students: " + entry.getValue());
        }


        List<String> studentsWithJ = studentMap.values()
                .stream()
                .filter(student -> student.getName().startsWith("J"))
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Students with names starting with J: " + studentsWithJ);
    }*/
}}

