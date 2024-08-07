import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="root";
        String query="INSERT INTO employees(id,name,job_title,salary) VALUES(4,'Raju','Android  Developer',85000);";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("connection is setup");
            Statement stmt = con.createStatement();

            int rowsAffected = stmt.executeUpdate(query);

            if(rowsAffected>0){
                System.out.println("Insert Successful: "+rowsAffected);
            }else {
                System.out.println("Insertion Failed!!" +
                        "");
            }



            stmt.close();
            con.close();
            System.out.println("conneciton closed successfully");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}