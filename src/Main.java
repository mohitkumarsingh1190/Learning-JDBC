
import java.sql.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException{

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="root";
        String withdrawQuery="UPDATE accounts SET balance = balance - ? WHERE account_number=?";
        String depositQuery="UPDATE accounts SET balance = balance + ? WHERE account_number=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("connection is setup");
            // automatic commits are banned here
            con.setAutoCommit(false);
            // batchStatement
            Statement statement = con.createStatement();
            statement.addBatch("INSERT INTO employees(name,job_title,salary)  VALUES('Vashu','HR Manager',65000)");
            statement.addBatch("INSERT INTO employees(name,job_title,salary)  VALUES('karan','Cyber Security Analyst',62000)");
            statement.addBatch("INSERT INTO employees(name,job_title,salary)  VALUES('Vipul','Android Deveoper',675000)");
            int[] batchResult = statement.executeBatch();
            con.commit();
            System.out.println("Batch Executed Successfully !!! ");


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}