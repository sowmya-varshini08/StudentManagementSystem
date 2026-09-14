import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add student
    public boolean addStudent(Student student) {

        // Check duplicate ID
        for (Student s : students) {

            if (s.getId() == student.getId()) {
                return false;
            }
        }

        students.add(student);
        return true;
    }

    // Display all students
    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Search student
    public Student searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // Update student
    public boolean updateStudent(
            int id,
            String name,
            int age,
            String department,
            double marks) {

        Student student = searchStudent(id);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setAge(age);
        student.setDepartment(department);
        student.setMarks(marks);

        return true;
    }

    // Delete student
    public boolean deleteStudent(int id) {

        Student student = searchStudent(id);

        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }

    // Number of students
    public int getStudentCount() {
        return students.size();
    }
}
