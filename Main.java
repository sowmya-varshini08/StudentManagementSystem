import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        while (true) {
            printMenu();

            int choice = readChoice();
            if (choice == -1) {
                continue;
            }

            if (handleChoice(manager, choice)) {
                return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n======================================");
        System.out.println("       STUDENT MANAGEMENT SYSTEM");
        System.out.println("======================================");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Student Count");
        System.out.println("7. Exit");
        System.out.print("\nEnter your choice: ");
    }

    private static int readChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine();
            return -1;
        }
    }

    private static boolean handleChoice(StudentManager manager, int choice) {
        switch (choice) {
            case 1:
                addStudent(manager);
                return false;
            case 2:
                System.out.println("\n--- All Students ---");
                manager.displayAllStudents();
                return false;
            case 3:
                searchStudent(manager);
                return false;
            case 4:
                updateStudent(manager);
                return false;
            case 5:
                deleteStudent(manager);
                return false;
            case 6:
                System.out.println("\nTotal Students: " + manager.getStudentCount());
                return false;
            case 7:
                System.out.println("\nThank you for using Student Management System!");
                scanner.close();
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
                return false;
        }
    }

    private static void addStudent(StudentManager manager) {
        System.out.println("\n--- Add Student ---");

        System.out.print("Enter Student ID: ");
        int id = readInt();

        System.out.print("Enter Name: ");
        String name = readLine();

        System.out.print("Enter Age: ");
        int age = readInt();

        System.out.print("Enter Department: ");
        String department = readLine();

        System.out.print("Enter Marks: ");
        double marks = readDouble();

        if (!isValidMarks(marks)) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        Student student = new Student(id, name, age, department, marks);
        if (manager.addStudent(student)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student ID already exists!");
        }
    }

    private static void searchStudent(StudentManager manager) {
        System.out.println("\n--- Search Student ---");

        System.out.print("Enter Student ID: ");
        int searchId = readInt();

        Student foundStudent = manager.searchStudent(searchId);
        if (foundStudent != null) {
            foundStudent.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent(StudentManager manager) {
        System.out.println("\n--- Update Student ---");

        System.out.print("Enter Student ID: ");
        int updateId = readInt();

        Student existingStudent = manager.searchStudent(updateId);
        if (existingStudent == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        String newName = readLine();

        System.out.print("Enter New Age: ");
        int newAge = readInt();

        System.out.print("Enter New Department: ");
        String newDepartment = readLine();

        System.out.print("Enter New Marks: ");
        double newMarks = readDouble();

        if (!isValidMarks(newMarks)) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        boolean updated = manager.updateStudent(updateId, newName, newAge, newDepartment, newMarks);
        if (updated) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Update failed.");
        }
    }

    private static void deleteStudent(StudentManager manager) {
        System.out.println("\n--- Delete Student ---");

        System.out.print("Enter Student ID: ");
        int deleteId = readInt();

        boolean deleted = manager.deleteStudent(deleteId);
        if (deleted) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static boolean isValidMarks(double marks) {
        return marks >= 0 && marks <= 100;
    }

    private static int readInt() {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static double readDouble() {
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    private static String readLine() {
        return scanner.nextLine();
    }
}
