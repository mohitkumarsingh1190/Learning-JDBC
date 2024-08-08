import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;
public class SchoolManagementSystem {
//    private static final String url = "jdbc:mysql://localhost:3306/myschool";
//    private static final String username = "root";
//    private static final String password = "root";


   // public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        }catch (ClassNotFoundException e){
//            System.out.println(e.getMessage());
//        }
//
//        try{
//            Connection connection = DriverManager.getConnection(url, username, password);
//            while(true){
//                System.out.println();
//                System.out.println("School Mangement System");
//                Scanner scanner = new Scanner(System.in);
//                System.out.println("1.Add New Admission ");
//                System.out.println("2. View Student details");
//                System.out.println("3. Get  Address of student");
//                System.out.println("4. Update student detail");
//                System.out.println("5. Suspended from school");
//                System.out.println("0. Exit");
//                System.out.print("Choose an option: ");
//                int choice = scanner.nextInt();
//                switch (choice) {
//                    case 1:
//                        NewAdmission(connection, scanner);
//                        break;
//                    case 2:
//                        viewDetail(connection);
//                        break;
//                    case 3:
//                        getAddress(connection, scanner);
//                        break;
//                    case 4:
//                        updateDetail(connection, scanner);
//                        break;
//                    case 5:
//                        Suspension(connection, scanner);
//                        break;
//                    case 0:
//                        exit();
//                        scanner.close();
//                        return;
//                    default:
//                        System.out.println("Invalid choice. Try again.");
//                }
//            }
//
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//
//
//    }
//    private static void NewAdmission(Connection connection, Scanner scanner) {
//        try {
//            System.out.print("Enter Student Name: ");
//            String StudentName = scanner.next();
//            scanner.nextLine();
//            System.out.print("Enter student student id: ");
//            int studentid = scanner.nextInt();
//            System.out.print("Enter mobile number: ");
//            String MobileNumber = scanner.next();
//
//            String sql = "INSERT INTO students (student_name, student_percentage  , student_mobile_no) " +
//                    "VALUES ('" + StudentName + "', " + studentid + ", '" + MobileNumber+ "')";
//
//            try (Statement statement = connection.createStatement()) {
//                int affectedRows = statement.executeUpdate(sql);
//
//                if (affectedRows > 0) {
//                    System.out.println("Admission successful!");
//                } else {
//                    System.out.println("Admission failed.");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }}
//    private static void viewDetail(Connection connection) throws SQLException {
//        String sql = "SELECT roll_no ,student_name , student_id  , student_mobile_no, address ";
//
//        try (Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(sql)) {
//
//            System.out.println("Current Reservations:");
//            System.out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");
//            System.out.println("| Student Roll no | StudentName          |studentid   | student mobile no  |     address        |");
//            System.out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");
//
//            while (resultSet.next()) {
//                int stuRollNo = resultSet.getInt(" roll_no ");
//                String StudentName = resultSet.getString(" student_name");
//                int  studentid = resultSet.getInt("student_id");
//                String  MobileNumber = resultSet.getString("student_mobile_no ");
//                String address = resultSet.getString("address");
//
//                // Format and display the reservation data in a table-like format
//                System.out.printf("| %-14d | %-15s | %-13d | %-20s | %-19s   |\n",
//                        stuRollNo, StudentName, studentid, MobileNumber, address);
//            }
//
//            System.out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");
//        }
//    }
//    private static void getAddress(Connection connection, Scanner scanner) {
//        try {
//            System.out.print("Enter roll no: ");
//            int studentRollNo = scanner.nextInt();
//            System.out.print("Enter Student name: ");
//            String StudentName = scanner.next();
//
//            String sql = "SELECT room_number FROM  students" +
//                    "WHERE  roll_no = " + studentRollNo +
//                    " AND guest_name = '" + StudentName  + "'";
//
//            try (Statement statement = connection.createStatement();
//                 ResultSet resultSet = statement.executeQuery(sql)) {
//
//                if (resultSet.next()) {
//                    int  studentid = resultSet.getInt("student_id");
//
//                    System.out.println(" for student roll no " + studentRollNo +
//                            " and Guest " + StudentName + " is: " + studentid);
//                } else {
//                    System.out.println("student  not found for the given ID and guest name.");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
//    }
   public static void main(String[] args) {
       System.out.println("hello world");
   }
}
