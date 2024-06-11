import java.sql.*;

public class Jdbc {

    private static final String url ="jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String username="root";
    private static final String password= "Akhtar@04";


    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            Connection connection = DriverManager.getConnection(url,username,password);

/*            String query = "SELECT marks FROM students WHERE id = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                double marks = resultSet.getDouble("marks");
                System.out.println("Marks : "+marks);
            }else {
                System.out.println("Marks Not found !!");
            }
*/

/*
            // Insert data

            String query = "INSERT INTO students(name , age , marks) VALUES(?, ? ,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"Obed");
            preparedStatement.setInt(2,18);
            preparedStatement.setDouble(3,94.4);


            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("DATA Inserted successfully");
            }else {
                System.out.println("Data Not Inserted !");
            }
*/

            // Data update
/*            String query = "UPDATE students SET marks = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setDouble(1,87);
            preparedStatement.setInt(2,3);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("DATA Updated successfully");
            }else {
                System.out.println("Data Not Updated !");
            }
*/

            // delete data

            String query = "DELETE FROM students WHERE id =? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1,3);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("DATA deleted  successfully");
            }else {
                System.out.println("Data Not deleted !");
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}

