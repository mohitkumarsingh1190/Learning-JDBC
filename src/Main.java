import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException{

        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="root";
        // ek jyada // lagana hoga
        String folder_path="C:\\Users\\merti\\Desktop\\colllege memories\\";
        String query ="SELECT image_data from image_table where image_id=(?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("connection is setup");

            //file outstream
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,1);

            //data retirving
            ResultSet resultSet =preparedStatement.executeQuery();
            if(resultSet.next()){
                // 1.Retrive --> 2. Java datatypes -->3.--->folder me daal denge

                byte[] image_data=resultSet.getBytes("image_data");
                // image path banayenge --> folder path se copy kre + image name(very very important)
                String image_path=folder_path+"extractdImage.jpg";
                OutputStream outputstream = new FileOutputStream(image_path);
                // arrays s data ko nikal kr write krega (image_data) --->image_path pr...
                outputstream.write(image_data);
                System.out.println("image found successfully at the folder ");
            }else {
                System.out.println("Image not found");
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