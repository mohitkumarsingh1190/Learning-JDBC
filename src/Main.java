import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

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
           try {
               // two instances
               PreparedStatement withdrawStatement = con.prepareStatement(withdrawQuery);
               PreparedStatement depositStatement=con.prepareStatement(depositQuery);
               //set values
               withdrawStatement.setDouble(1,500.00);
               withdrawStatement.setString(2,"account123");
               depositStatement.setDouble(1,500.00);
               depositStatement.setString(2,"account456");
               withdrawStatement.executeUpdate();
               depositStatement.executeUpdate();

               con.commit();
               System.out.println("Transaction Successfull!!");

           }catch (SQLException e){
               con.rollback();
               System.out.println("Transaction failed");
           }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}