import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="root";
        String query = "INSERT INTO employees(id,name,job_title,salary) VALUES(?,?,?,?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("connection is setup");
            PreparedStatement preparedStatement =con.prepareStatement(query);
            preparedStatement.setInt(1,3);
            preparedStatement.setString(2,"Mohit Kumar Singh");
            preparedStatement.setString(3,"DevOps Engineer");

            preparedStatement.setDouble(4,90000.0);

           int rowsAffected=preparedStatement.executeUpdate();

           if(rowsAffected>0){
               System.out.println("Data Inserted Successfully!!");
           }else {
               System.out.println("Data Insertion Failed");
           }
            preparedStatement.close();
            con.close();
            System.out.println("conneciton closed successfully");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}