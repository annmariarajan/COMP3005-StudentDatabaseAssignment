import java.sql.*;

public class StudentManager {

    private static String url = "jdbc:postgresql://<HOST>:<PORT>/<DATABASE_NAME>";
    private static String user = "<USERNAME>";
    private static String password = "<PASSWORD>";

    // Database connection method
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    // READ: Retrieve and display all students
    public static void getAllStudents() throws SQLException {
        String sql = "SELECT * FROM students";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String email = rs.getString("email");
                Date date = rs.getDate("enrollment_date");

                System.out.println("StudentID: " + id +
                        " First Name: " + fName +
                        " Last Name: " + lName +
                        " Email: " + email +
                        " Enrollment Date: " + date);
            }
        }
    }

    // CREATE: Insert a new student into the database
    public static void addStudent(String fName, String lName, String email, Date enrollDate) throws SQLException {

        String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date)" + "VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, fName);
            pstmt.setString(2, lName);
            pstmt.setString(3, email);
            pstmt.setDate(4, enrollDate);

            pstmt.executeUpdate();

            System.out.println("Student added successfully.");
        }
    }

    // UPDATE: Change a student's email using their student ID
    public static void updateStudentEmail(int studentID, String newEmail) throws SQLException {
        String updateSQL = "UPDATE students SET email = ? WHERE student_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // Set the new email address and specify which student's record to update using their ID
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, studentID);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Student email updated successfully.");
            } else {
                System.out.println("Student ID not found.");
            }
        }
    }

    // DELETE: Remove a student using their student ID
    public static void deleteStudent(int studentID) throws SQLException  {

        String deleteSQL = "DELETE FROM students WHERE student_id = ?" ;
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

            // Specify which student's record to delete using their ID
            pstmt.setInt(1, studentID);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student ID not found.");
            }
        }
    }
}
