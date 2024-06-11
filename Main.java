import java.sql.*;

public class Main {

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
            Statement statement = connection.createStatement();

//            // 1.Data Retrived
//
//            String query = "select * from students";
//            ResultSet resultSet = statement.executeQuery(query);
//            while(resultSet.next())
//            {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                double marks = resultSet.getDouble("marks");
//
//                System.out.println("ID : "+id);
//                System.out.println("Name : "+name);
//                System.out.println("Age : "+age);
//                System.out.println("Marks : "+ marks);
//            }

        /*

          //2. Data INSERT

            String query = String.format("INSERT INTO students(name ,age,marks) VALUES('%s',%o,%f)","AKHTAR",21,85.7);

            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("DATA Inserted successfully");
            }else {
                System.out.println("Data Not Inserted !");
            }


         */


     /*       //3. Data UPDATE

            String query = String.format("UPDATE students SET marks = %f WHERE id = %d ",92.45 ,2);

            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("DATA Update successfully");
            }else {
                System.out.println("Data Not Updated !");
            }
     */

            // Deleted data

            String query = String.format("DELETE FROM students WHERE ID = 2");

            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("DATA DELETED successfully");
            }else {
                System.out.println("Data Not DELETED !");
            }



        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
