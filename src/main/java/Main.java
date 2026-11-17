import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try {
            // Display all students
            StudentManager.getAllStudents();

            // Add a student
            StudentManager.addStudent("Angel", "Mendes",
                    "angel.mendes@example.com", Date.valueOf("2026-11-16"));

            // Update a student's email
            StudentManager.updateStudentEmail(4, "angel.new@example.com");

            // Delete a student
            StudentManager.deleteStudent(4);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

}
