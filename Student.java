public class Student {

    private int id;
    private String name;
    private int age;
    private String department;
    private double marks;

    // Constructor
    public Student(int id, String name, int age, String department, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.marks = marks;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getMarks() {
        return marks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Calculate grade
    public String getGrade() {

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // Display student details
    public void displayStudent() {

        System.out.println("--------------------------------------");
        System.out.println("Student ID  : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Department  : " + department);
        System.out.println("Marks       : " + marks);
        System.out.println("Grade       : " + getGrade());
        System.out.println("--------------------------------------");
    }
}
    

