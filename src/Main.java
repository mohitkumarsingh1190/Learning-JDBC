import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="root";
        String query = "Select * from employees where name = ?  ;";

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
            preparedStatement.setString(1,"Hemant");
//            preparedStatement.setString(2,"Game Developer ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                // java local variable = database variable
                int id = resultSet.getInt("id");
                String name=resultSet.getString("name");
                String job_title=resultSet.getString("job_title");
                double salary = resultSet.getDouble("salary");
                System.out.println("ID: "+id);
                System.out.println("NAME: "+name);
                System.out.println("JOB TITLE: "+job_title);
                System.out.println("SALARY: "+salary);
            }
            resultSet.close();
            preparedStatement.close();
            con.close();
            System.out.println("conneciton closed successfully");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}