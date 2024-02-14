import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;



    import java.util.*;

    public class App {
    public static void main(String[] args) {
        // 3- Créez une Map appelée studentMap qui fait correspondre l'identifiant de chaque étudiant à son objet Student
        Map<Integer, Student> studentMap = new HashMap<>();

        // 4- Ajoutez quelques objets Student à la Map
        Student student1 = new Student("Jason", 2001);
        student1.addCourse("Math");
        student1.addCourse("Science");
        student1.addCourse("History");
        studentMap.put(student1.getId(), student1);

        Student student2 = new Student("Ava", 2002);
        student2.addCourse("English");
        student2.addCourse("Science");
        student2.addCourse("Art");
        studentMap.put(student2.getId(), student2);

        Student student3 = new Student("Mike", 2003);
        student3.addCourse("Math");
        student3.addCourse("History");
        student3.addCourse("Geography");
        studentMap.put(student3.getId(), student3);

        // 5- Parcourez la Map à l'aide d'une boucle for et affichez le nom, l'identifiant et les cours de chaque étudiant
        System.out.println("Liste des étudiants :");
        for (Student student : studentMap.values()) {
            System.out.println("Name: " + student.getName() + " ID: " + student.getId() + " Courses: " + student.getCourses());
        }

        // 6- Créez une liste de tous les cours suivis par les étudiants
        List<String> allCourses = new ArrayList<>();
        for (Student student : studentMap.values()) {
            allCourses.addAll(student.getCourses());
        }

        // 7- Supprimez les cours en double de la liste en utilisant un Set
        Set<String> uniqueCourses = new HashSet<>(allCourses);

        // 8- Parcourez les cours uniques à l'aide d'une boucle for et affichez chaque cours
        System.out.println("\nListe des cours uniques :");
        for (String course : uniqueCourses) {
            System.out.print( " "+course );
        }

        // 9- Créez une Map qui fait correspondre chaque cours à une liste d'étudiants qui suivent ce cours
        Map<String, List<String>> courseMap = new HashMap<>();
        for (Student student : studentMap.values()) {
            for (String course : student.getCourses()) {
                if (!courseMap.containsKey(course)) {
                    courseMap.put(course, new ArrayList<>());
                }
                courseMap.get(course).add(student.getName());
            }
        }

        // 10- Parcourez la Map à l'aide d'une boucle for et affichez le cours et la liste d'étudiants qui suivent ce cours
        System.out.println("\nListe des étudiants par cours :");
        for (Map.Entry<String, List<String>> entry : courseMap.entrySet()) {
            String course = entry.getKey();
            List<String> students = entry.getValue();
            System.out.println(course + ": " + students);
        }

        // 11- Utilisez les streams pour créer une liste d'étudiants dont le nom commence par la lettre "J" et affichez leurs noms
        List<String> studentsWithJNames = studentMap.values()
                .stream()
                .filter(student -> student.getName().startsWith("J"))
                .map(Student::getName)
                .toList();

        System.out.println("\nÉtudiants dont le nom commence par 'J' :");
        for (String name : studentsWithJNames) {
            System.out.println(name);
        }
    }
}


 /* 
        public static void main(String[] args) {
            Map<Integer, Student> studentMap = new HashMap<>();
    
            // Ajoutez quelques objets Student à la Map
            Student student1 = new Student("John", 1);
            student1.addCourse("Math");
            student1.addCourse("Science");
            studentMap.put(student1.getId(), student1);
    
            Student student2 = new Student("Jane", 2);
            student2.addCourse("History");
            student2.addCourse("English");
            studentMap.put(student2.getId(), student2);
    
            Student student3 = new Student("Jake", 3);
            student3.addCourse("Art");
            student3.addCourse("Science");
            studentMap.put(student3.getId(), student3);
    
            // Parcourez la Map et affichez les informations de chaque étudiant
            for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
                int id = entry.getKey();
                Student student = entry.getValue();
                System.out.println("Nom : " + student.getName());
                System.out.println("ID : " + student.getId());
                System.out.println("Cours : " + student.getCourses());
            }
    
            // Créez une liste de tous les cours suivis par les étudiants
            List<String> allCourses = new ArrayList<>();
            for (Student student : studentMap.values()) {
                allCourses.addAll(student.getCourses());
            }
    
            // Supprimez les cours en double de la liste en utilisant un Set
            Set<String> uniqueCourses = new HashSet<>(allCourses);
    
            // Parcourez les cours uniques et affichez-les
            for (String course : uniqueCourses) {
                System.out.println(course);
            }
    
            // Créez une Map qui fait correspondre chaque cours à une liste d'étudiants
            Map<String, List<Student>> courseMap = new HashMap<>();
            for (Student student : studentMap.values()) {
                List<String> courses = student.getCourses();
                for (String course : courses) {
                    if (courseMap.containsKey(course)) {
                        courseMap.get(course).add(student);
                    } else {
                        List<Student> students = new ArrayList<>();
                        students.add(student);
                        courseMap.put(course, students);
                    }
                }
            }


    
            // Parcourez la Map et affichez le cours et les étudiants qui le suivent
            for (Map.Entry<String, List<Student>> entry : courseMap.entrySet()) {
                String course = entry.getKey();
                List<Student> students = entry.getValue();
                System.out.println("Cours : " + course);
                for (Student student : students) {
                    System.out.println(  course + "["+student.getName()+"]");
                }
            }
    
        

              // Utilisez les streams pour créer une liste d'étudiants dont le nom commence par "J"
        List<String> studentsWithJ = studentMap.values()
        .stream()  
        .filter(student -> student.getName().startsWith("J"))
        .map(Student::getName)
        .collect(Collectors.toList());
// Affichez les noms des étudiants dont le nom commence par "J"
System.out.println("Students with names starting with J: " + studentsWithJ);
        }
    }


    /* 
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

  
        Set<String> uniqueCourses = new HashSet<>(allCourses);


        for (String course : uniqueCourses) {
            System.out.println(" Unique Course: " + course);
        }
        // Créez une Map qui fait correspondre chaque cours à une liste d'étudiants
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
            System.out.println(entry.getKey() +":" +entry.getValue());
           // System.out.println("Students: " + entry.setValue());
        }


        List<String> studentsWithJ = studentMap.values()
                .stream()
                .filter(student -> student.getName().startsWith("J"))
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("Students with names starting with J: " + studentsWithJ);
    }*/





