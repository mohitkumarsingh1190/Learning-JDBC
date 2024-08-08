import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException{

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="root";
        String image_path="C:\\Users\\merti\\Desktop\\colllege memories\\1000014401.jpg";
        String query="INSERT INTO image_table(image_data) VALUES(?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("connection is setup");

            // java me lane k liye bytes me convert krna padega
            // fileinputStream ---> instance-->image to binary format
            FileInputStream fileInputStream=new FileInputStream(image_path);
            // array me store krna hoga --->data type should of byte type
            byte[] imageData = new byte[fileInputStream.available()];
            fileInputStream.read(imageData);
            PreparedStatement preparedStatement= con.prepareStatement(query);
            preparedStatement.setBytes(1,imageData);
            int affectedRows= preparedStatement.executeUpdate();
            if(affectedRows>0){
                System.out.println("Image Inserted Successful !!");
            }else {
                System.out.println("Insertion failed !!!!");
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}